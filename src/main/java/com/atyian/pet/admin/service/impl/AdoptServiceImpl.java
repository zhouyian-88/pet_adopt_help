package com.atyian.pet.admin.service.impl;

import com.atyian.pet.admin.controller.AdoptController;
import com.atyian.pet.admin.controller.request.AdoptPageRequest;
import com.atyian.pet.admin.mapper.AdoptMapper;
import com.atyian.pet.admin.mapper.PetMapper;
import com.atyian.pet.admin.pojo.Adopt;
import com.atyian.pet.admin.pojo.Pet;
import com.atyian.pet.admin.service.AdoptService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-16-22:00
 */
@Service
public class AdoptServiceImpl implements AdoptService {
    @Autowired
    private AdoptMapper adoptMapper;
    @Autowired
    private PetMapper petMapper;
    @Override
    public Object listAdoptByCondition(AdoptPageRequest adoptPageRequest) {
        PageHelper.startPage(adoptPageRequest.getPageNum(), adoptPageRequest.getPageSize());
        List<Adopt> adoptList = adoptMapper.selectAdoptByCondition(adoptPageRequest);
        return new PageInfo<>(adoptList);
    }

    @Override
    public int createAdopt(Adopt adopt) {
        //创建收养记录的同时也要修改宠物表中该宠物的状态
        Pet pet = new Pet();
        pet.setPkPetId(adopt.getPetId());
        pet.setState(3);
        petMapper.updateByPrimaryKeySelective(pet);
        adopt.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return adoptMapper.insertSelective(adopt);
    }

    @Override
    public Adopt getAdoptByAdoptId(Long adoptId) {
        return adoptMapper.selectByPrimaryKey(adoptId);
    }

    @Override
    public int updateAdoptByAdoptId(Adopt adopt) {
        //如果修改了收养的宠物，那么就要把原先的宠物的状态修改为未收养，把修改的宠物修改成审核中
        //根据收养的id把宠物的信息查询出来
        Integer pkAdoptId = adopt.getPkAdoptId();//得到收养记录
        Adopt adopt1 = adoptMapper.selectByPrimaryKey(Long.valueOf(pkAdoptId));//查到原petId
        //把传过来的宠物id与原来的进行对比
        Pet pet = petMapper.selectByPrimaryKey(Long.valueOf(adopt1.getPetId()));
        if(!(adopt1.getPetId()==adopt.getPetId())){
            Pet pet1 = new Pet();
            //数据库原来的pet的状态修改 2 未收养
            pet1.setPkPetId(pet.getPkPetId());
            pet1.setState(2);
            petMapper.updateByPrimaryKeySelective(pet1);
            //把传过来的宠物的状态 3 审核中
            pet1.setPkPetId(adopt.getPetId());
            pet1.setState(3);
            petMapper.updateByPrimaryKeySelective(pet1);
        }
            adopt.setUpdateTime(new Timestamp(System.currentTimeMillis()));
            return adoptMapper.updateByPrimaryKeySelective(adopt);


    }

    @Override
    public int deleteAdoptByAdoptId(Long adoptId) {
        //根据adoptId查询adopt的详细信息
        Adopt adopt = adoptMapper.selectByPrimaryKey(adoptId);
        //得到pet对象
        Pet pet = petMapper.selectByPrimaryKey(Long.valueOf(adopt.getPetId()));
        if(pet.getState()==3){
            Pet pet1 = new Pet();
            pet1.setPkPetId(pet.getPkPetId());
            //修改其状态 2
            pet1.setState(2);
            petMapper.updateByPrimaryKeySelective(pet1);

        }
            return adoptMapper.deleteByPrimaryKey(adoptId);



    }

    @Override
    public int updateAdoptForAgreeAndDisAgree(Long adoptId,Integer sign) {
        //查询到当前adopt信息
        Adopt adopt = adoptMapper.selectByPrimaryKey(adoptId);
        //得到pet对象
        Pet pet = petMapper.selectByPrimaryKey(Long.valueOf(adopt.getPetId()));
        //修改pet状态
        if(sign == 1){//到sign等于1，就代表是同意
            Pet pet1 = new Pet();
            pet1.setPkPetId(pet.getPkPetId());
            //修改其状态 2
            pet1.setState(2);
            petMapper.updateByPrimaryKeySelective(pet1);
            //修改adopt状态
            adopt.setState(1);
            adoptMapper.updateByPrimaryKeySelective(adopt);
        }else if(sign == 2){
            Pet pet1 = new Pet();
            pet1.setPkPetId(pet.getPkPetId());
            //修改其状态 2
            pet1.setState(2);
            petMapper.updateByPrimaryKeySelective(pet1);
            //修改adopt状态
            adopt.setState(2);
            adoptMapper.updateByPrimaryKeySelective(adopt);
        }
        return 1;
    }
}
