package com.atyian.pet.admin.mapper;

import com.atyian.pet.admin.controller.request.PetPageRequest;
import com.atyian.pet.admin.pojo.Pet;

import java.util.List;

/**
* @author ZHOUYIAN
* @description 针对表【pet_pet】的数据库操作Mapper
* @createDate 2022-12-16 13:31:33
* @Entity com.atyian.pet.admin.pojo.Pet
*/
public interface PetMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Pet record);

    int insertSelective(Pet record);

    Pet selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Pet record);

    int updateByPrimaryKey(Pet record);

    /**
     * 根据条件分页查询宠物列表
     * @param petPageRequest
     * @return
     */
     List<Pet> selectPetByCondition(PetPageRequest petPageRequest);

}
