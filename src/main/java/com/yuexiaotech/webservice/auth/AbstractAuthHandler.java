package com.yuexiaotech.webservice.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author songzheng.msz
 * @date 11:51 PM 2019/1/22.
 */
public abstract class AbstractAuthHandler {
    protected static final Logger logger = LoggerFactory.getLogger(AbstractAuthHandler.class);


    /**
     * BASIC鉴权
     */
    public void doAuthCheck() {
        logger.info("do auth check");
    }
}
