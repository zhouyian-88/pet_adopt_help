package com.atyian.pet.admin.controller;

import com.atyian.pet.admin.pojo.Admin;
import com.atyian.pet.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-12-07-21:56
 */
@Controller
@RequestMapping("/admin")
public class PageController {
    @Autowired
    private AdminService adminService;

    /**
     * 该方法用于首页登录
     * @return
     */
    @GetMapping("/")
    public String toIndex(){
        return "admin/index";
    }

    /**
     * 该方法用于登出用户
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "admin/login";
    }

    //通用页面加载
    @RequestMapping("{page}")
    public String page(@PathVariable String page){
        return "admin/"+page;
    }
}
