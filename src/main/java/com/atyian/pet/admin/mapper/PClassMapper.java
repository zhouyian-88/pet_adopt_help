package com.atyian.pet.admin.mapper;

import com.atyian.pet.admin.controller.request.PClassPageRequest;
import com.atyian.pet.admin.pojo.PClass;

import java.util.List;

/**
* @author ZHOUYIAN
* @description 针对表【pet_class】的数据库操作Mapper
* @createDate 2022-12-15 17:07:16
* @Entity com.atyian.pet.admin.pojo.PClass
*/
public interface PClassMapper {

    int deleteByPrimaryKey(Long id);

    int insert(PClass record);

    int insertSelective(PClass record);

    PClass selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PClass record);

    int updateByPrimaryKey(PClass record);

    /**
     * 根据条件分页查询宠物的种类
     * @param pClassPageRequest
     * @return
     */
    List<PClass> selectPClassByCondition(PClassPageRequest pClassPageRequest);

    /**
     * 根据petType查询是否有此宠物
     * @param petType
     * @return
     */
    PClass selectPetType(String petType);

}
