package com.atyian.pet.admin.controller;

import com.atyian.pet.admin.controller.request.AdoptPageRequest;
import com.atyian.pet.admin.pojo.Admin;
import com.atyian.pet.admin.pojo.Adopt;
import com.atyian.pet.admin.service.AdoptService;
import com.atyian.pet.common.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-16-22:03
 */
@RestController
@RequestMapping("/admin/adopt")
public class AdoptController {

    @Autowired
    private AdoptService adoptService;

    @GetMapping("/list")
    public CommonResult list(AdoptPageRequest adoptPageRequest){
        Object adopt = adoptService.listAdoptByCondition(adoptPageRequest);
        if(adopt != null){
            return CommonResult.success(adopt);
        }else{
            return CommonResult.fail("查询失败");
        }
    }

    @PostMapping("/create")
    public CommonResult create(Adopt adopt,HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        adopt.setAdminId(admin.getPkAdminId());
        adopt.setAdminName(admin.getAdminName());
        int result = adoptService.createAdopt(adopt);
        if(result==1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("创建失败");
        }
    }

    @GetMapping("/query")
    public CommonResult query(Long id){
        Adopt adopt = adoptService.getAdoptByAdoptId(id);
        if(adopt!=null){
            return CommonResult.success(adopt);
        }else{
            return CommonResult.fail("查询失败");
        }
    }

    @PostMapping("/update")
    public CommonResult update(Adopt adopt, HttpSession session){
        Admin admin = (Admin) session.getAttribute("admin");
        adopt.setAdminId(admin.getPkAdminId());
        adopt.setAdminName(admin.getAdminName());
        int result = adoptService.updateAdoptByAdoptId(adopt);
        if(result == 1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("修改失败");
        }

    }

    @GetMapping("/delete")
    public CommonResult delete(Long id){
        int result = adoptService.deleteAdoptByAdoptId(id);
        if(result==1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("删除失败");
        }
    }

    @PostMapping("/agreeAndDisagree")
    public CommonResult agreeAndDisagree(@RequestParam("id") Long id,@RequestParam("sign") Integer sign){
        int result = adoptService.updateAdoptForAgreeAndDisAgree(id, sign);
        if(result == 1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("失败");
        }
    }
}
