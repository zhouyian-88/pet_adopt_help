package com.atyian.pet.admin.controller;

import com.atyian.pet.admin.controller.request.CommonPageRequest;
import com.atyian.pet.admin.pojo.User;
import com.atyian.pet.admin.service.UserService;
import com.atyian.pet.common.CommonResult;
import com.atyian.pet.util.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.stream.events.Comment;
import java.io.IOException;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-14-21:57
 */
@RestController
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/list")
    public CommonResult list(CommonPageRequest CommonPageRequest){
        return CommonResult.success(   userService.listUserByCondition(CommonPageRequest));
    }

    @PostMapping("/create")
    public CommonResult create(@RequestParam( value="file",required=false)MultipartFile picture, User user) throws IOException {
        String fileName = UploadFile.uploadImage(picture);
        user.setPicture(fileName);
        int result = userService.createUser(user);
        if(result == 1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("创建失败");
        }

    }

    @PostMapping("/update")
    public CommonResult update(@RequestParam( value="file",required=false)MultipartFile picture, User user) throws IOException {
        if(picture!=null){
            String newFileName = UploadFile.uploadImage(picture);
            user.setPicture(newFileName);
        }
        int result = userService.updateUserByUserId(user);
        if(result == 1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("修改失败");
        }

    }

    @GetMapping("/query")
    public CommonResult query(Long id){
        User user = userService.getUserByUserId(id);
        if(user != null){
            return CommonResult.success(user);
        }else{
            return CommonResult.fail("查询失败");
        }
    }

    @GetMapping("/delete")
    public CommonResult delete(Long id){
        int result = userService.deleteUserByUserId(id);
        if(result == 1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("删除失败");
        }
    }

}
