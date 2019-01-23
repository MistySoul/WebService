package com.yuexiaotech.webservice.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.yuexiaotech.webservice.auth.AbstractAuthHandler;
import com.yuexiaotech.webservice.spring.SpringContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author songzheng.msz
 * @date 11:44 PM 2019/1/22.
 */
@Component
@Aspect
@Order(10)
public class CommonControlAdvice {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface OpenApiAdvice {
        boolean auth() default false;
    }

    public static final Logger logger = LoggerFactory.getLogger(CommonControlAdvice.class);

    @Around("@annotation(openApiAdvice)")
    public Object doApiAuth(ProceedingJoinPoint pjp, OpenApiAdvice openApiAdvice) throws Throwable {
        Object[] args = pjp.getArgs();

        Object requestObject = args[0];

        logger.info("requestObject:{}", requestObject);

        if (requestObject instanceof String) {
            logger.info("input from request:{}", requestObject.toString());
        }

        // ram鉴权
        if (openApiAdvice.auth()) {

            try {
                //获取spring bean
                ApplicationContext app = SpringContextHolder.getApplicationContext();
                AbstractAuthHandler abstractAuthHandler = app.getBean("abstractAuthHandler", AbstractAuthHandler.class);

                //鉴权
                abstractAuthHandler.doAuthCheck();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        try {
            Object response = pjp.proceed();

            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
