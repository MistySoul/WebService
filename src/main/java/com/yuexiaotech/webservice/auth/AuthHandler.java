package com.yuexiaotech.webservice.auth;

import org.springframework.stereotype.Controller;

/**
 * @author songzheng.msz
 * @date 11:57 PM 2019/1/22.
 */
@Controller("abstractAuthHandler")
public class AuthHandler extends AbstractAuthHandler {

    /**
     * 业务鉴权，如果需要的话
     */
    @Override
    public void doAuthCheck() {
        //todo
        super.doAuthCheck();
    }
}
