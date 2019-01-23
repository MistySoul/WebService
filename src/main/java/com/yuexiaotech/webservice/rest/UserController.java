package com.yuexiaotech.webservice.rest;

import com.yuexiaotech.webservice.aspect.CommonControlAdvice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author songzheng.msz
 * @date 11:33 PM 2019/1/22.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/check/{str}", method = RequestMethod.GET)
    @CommonControlAdvice.OpenApiAdvice(auth = true)
    public String check(@PathVariable String str){
        return "SUCCESS" + str;
    }

}
