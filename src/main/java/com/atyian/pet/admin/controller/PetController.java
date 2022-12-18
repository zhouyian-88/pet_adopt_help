package com.atyian.pet.admin.controller;

import com.atyian.pet.admin.controller.request.PetPageRequest;
import com.atyian.pet.admin.pojo.Pet;
import com.atyian.pet.admin.service.PetService;
import com.atyian.pet.common.CommonResult;
import com.atyian.pet.util.UploadFile;
import com.sun.scenario.effect.impl.state.PerspectiveTransformState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-16-13:54
 */
@RestController
@RequestMapping("/admin/pet")
public class PetController {
    @Autowired
    private PetService petService;
    @GetMapping("/list")
    public CommonResult list(PetPageRequest petPageRequest){
        Object pet = petService.listPetByCondition(petPageRequest);
        if(pet != null){
            return CommonResult.success(pet);
        }else{
            return CommonResult.fail("查询失败");
        }
    }

    @GetMapping("/findPetType")
    public CommonResult findPetType(String petType){
        Object petList = petService.listPClassByPetType(petType);
        if(petList != null){
            return CommonResult.success(petList);
        }else{
            return CommonResult.fail("查询失败");
        }

    }

    @PostMapping("/create")
    public CommonResult create(@RequestParam( value="file",required=false) MultipartFile picture, Pet pet) throws IOException {
        String fileName = UploadFile.uploadImage(picture);
        pet.setPicture(fileName);
        int result = petService.createPet(pet);
        if(result == 1){
            return CommonResult.success();
        }else{
            return CommonResult.fail("创建失败");
        }
    }
   @PostMapping("/update")
    public CommonResult update(@RequestParam( value="file",required=false) MultipartFile picture,Pet pet) throws IOException {
        if(picture != null){
            String fileName = UploadFile.uploadImage(picture);
            pet.setPicture(fileName);
        }
       int result = petService.updatePetByPetId(pet);
       if(result==1){
           return CommonResult.success();
       }else{
           return CommonResult.fail("修改失败");
       }
   }

   @GetMapping("/query")
   public CommonResult query(Long id){
       Pet pet = petService.getPetByPetId(id);
       if(pet != null){
           return CommonResult.success(pet);
       }else{
           return CommonResult.fail("查询失败");
       }
   }

   @GetMapping("/delete")
   public CommonResult delete(Long id){
       int result = petService.deletePetByPetId(id);
       if(result ==1){
           return CommonResult.success();
       }else{
           return CommonResult.fail("删除失败");
       }
   }

   @GetMapping("/petName")
    public CommonResult petName(String petName){
       Object pet = petService.listPetByPetName(petName);
       if(pet != null){
           return CommonResult.success(pet);
       }else{
           return CommonResult.fail("查询失败");
       }
   }
}
