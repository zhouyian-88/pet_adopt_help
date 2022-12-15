package com.atyian.pet.admin.controller;

import com.atyian.pet.admin.controller.request.PClassPageRequest;
import com.atyian.pet.admin.pojo.PClass;
import com.atyian.pet.admin.service.PClassService;
import com.atyian.pet.common.CommonResult;
import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-15-16:31
 */

@RestController
@RequestMapping("/admin/pclass")
public class PClassController {

    @Autowired
    private PClassService pClassService;
    @GetMapping("/list")
    public CommonResult list(PClassPageRequest pClassPageRequest){
        Object pclassInfo = pClassService.listPClassByCondition(pClassPageRequest);
        if(pclassInfo!=null){
            return CommonResult.success(pclassInfo);
        }else{
            return CommonResult.fail("查询失败");
        }
    }

    @PostMapping("/create")
    public CommonResult create(PClass pClass){
        int pClass1 = pClassService.createPClass(pClass);
        if(pClass1 == 1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("创建失败");
        }
    }

    @GetMapping("/hasPetType")
    public CommonResult hasPetType(String petType){
        boolean hasPet = pClassService.hasPetType(petType);
        if(!hasPet){
            return CommonResult.success();
        }else{
            return CommonResult.fail("已存在");
        }
    }


    @GetMapping("/query")
    public CommonResult query(Long id){
        PClass pClass = pClassService.getPClassById(id);
        if(pClass!=null){
            return CommonResult.success(pClass);
        }else{
            return CommonResult.fail("查找失败");
        }
    }


    @PostMapping("/update")
    public CommonResult update(PClass pClass){
        int result = pClassService.updatePClass(pClass);
        if(result==1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("修改失败");
        }

    }

    @GetMapping("/delete")
    public CommonResult delete(Long id){
        int result = pClassService.deletePClassById(id);
        if(result==1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("删除失败");
        }
    }
}
