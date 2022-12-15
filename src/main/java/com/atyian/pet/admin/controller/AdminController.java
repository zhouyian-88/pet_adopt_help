package com.atyian.pet.admin.controller;

import com.atyian.pet.admin.controller.request.CommonPageRequest;
import com.atyian.pet.admin.pojo.Admin;
import com.atyian.pet.admin.service.AdminService;
import com.atyian.pet.common.CommonResult;
import com.atyian.pet.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;


/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-12-02-14:21
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    /**
     * 该方法用于登录验证
     * @param nickname
     * @param password
     * @return
     */
    @PostMapping("/login")
    public CommonResult login(@RequestParam("nickname") String nickname, @RequestParam("password")String password, HttpServletRequest request){
        Admin admin = adminService.selectForOne(nickname, password);

        //将获取到的对象保存到session域中
        HttpSession session = request.getSession();
        session.setAttribute("admin", admin);
        if(admin == null){
            return CommonResult.fail("用户名或密码错误！！！");
        }
        return CommonResult.success();
    }
    /**
     * 该方法用于创建用户
     * @param admin
     * @return
     */
    @PostMapping("/create")
    public CommonResult create(@RequestParam( value="file",required=false)MultipartFile picture,Admin admin) throws IOException {
        String newFileName = UploadFile.uploadImage(picture);
        admin.setPicture(newFileName);
        int result = adminService.create(admin);
        if(result == 1){
            return CommonResult.success();
        }else{
            return  CommonResult.fail("创建失败");
        }

    }

    /**
     * 根据条件分页查询管理员信息
     * @return
     */
    @GetMapping("/list")
    public CommonResult list(CommonPageRequest adminPageRequest){
        Object admin = adminService.listByCondition(adminPageRequest);
        if(admin != null){
            return CommonResult.success();
        }else{
            return CommonResult.fail("查询失败");
        }

    }

    /**
     * 该方法用于修改管理员信息
     * @param admin
     * @return
     */
    @PostMapping("/update")
    public CommonResult update(@RequestParam( value="file",required=false)MultipartFile picture,Admin admin) throws IOException {
        if(picture!=null){
            String newFileName = UploadFile.uploadImage(picture);
            admin.setPicture(newFileName);
        }
        int result = adminService.updateByPrimaryKey(admin);
        if(result == 1){
            return CommonResult.success();
        }else{
            return  CommonResult.fail("创建失败");
        }
    }


    /**
     * 该方法用于根据查询
     * @param id
     * @return
     */
    @GetMapping("/query")
    public CommonResult query(Integer id){
        Admin admin = adminService.getAdminByPrimaryKey(id);
//        System.out.println(admin);
        if(admin != null){
            return CommonResult.success();
        }else{
            return CommonResult.fail("查询失败");
        }
    }

    /**
     * 该方法用于删除
     * @param id
     * @return
     */
    @GetMapping("/delete")
    public CommonResult delete(Integer id){
        int result = adminService.deleteAdminByPrimaryKey(id);
        if(result == 1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("删除失败");
        }
    }

}
