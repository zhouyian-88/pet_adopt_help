package com.atyian.pet.admin.service.impl;

import com.atyian.pet.admin.controller.request.PClassPageRequest;
import com.atyian.pet.admin.controller.request.PetPageRequest;
import com.atyian.pet.admin.mapper.PetMapper;
import com.atyian.pet.admin.pojo.PClass;
import com.atyian.pet.admin.pojo.Pet;
import com.atyian.pet.admin.service.PClassService;
import com.atyian.pet.admin.service.PetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.runtime.internal.PerObjectMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-16-13:52
 */
@Service
public class PetServiceImpl implements PetService {
    @Autowired
    private PetMapper petMapper;
    @Autowired
    private PClassService pClassService;
    @Override
    public Object listPetByCondition(PetPageRequest petPageRequest) {
        PageHelper.startPage(petPageRequest.getPageNum(), petPageRequest.getPageSize());
        List<Pet> petList = petMapper.selectPetByCondition(petPageRequest);
        return new PageInfo<>(petList);
    }

    @Override
    public Object listPClassByPetType(String petType) {
        PClassPageRequest pClassPageRequest = new PClassPageRequest();
        pClassPageRequest.setPageNum(1);
        pClassPageRequest.setPageSize(5);
        pClassPageRequest.setPetType(petType);

        Object pclass = pClassService.listPClassByCondition(pClassPageRequest);
//        System.out.println(pclass);

        return pclass;
    }

    @Override
    public int createPet(Pet pet) {
        pet.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return petMapper.insertSelective(pet);
    }

    @Override
    public int updatePetByPetId(Pet pet) {
        pet.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return petMapper.updateByPrimaryKeySelective(pet);
    }

    @Override
    public Pet getPetByPetId(Long petId) {
        return petMapper.selectByPrimaryKey(petId);
    }

    @Override
    public int deletePetByPetId(Long petId) {
        return petMapper.deleteByPrimaryKey(petId);
    }
}
