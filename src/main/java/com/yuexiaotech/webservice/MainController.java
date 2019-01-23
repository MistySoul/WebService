package com.yuexiaotech.webservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author songzheng.msz
 * @date 11:39 PM 2019/1/22.
 */
@Controller
public class MainController {

    /**
     * 健康检查，系统部署需要
     * 请不要删除！！
     */
    @GetMapping("/checkpreload.htm")
    public @ResponseBody
    String checkPreload() {
        return "success";
    }
}
