package com.atyian.pet.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-11-02-17:13
 */
@Controller
public class IndexController {

    /**
     *
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

}
