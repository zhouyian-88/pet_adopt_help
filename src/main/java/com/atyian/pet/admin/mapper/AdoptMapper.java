package com.atyian.pet.admin.mapper;

import com.atyian.pet.admin.controller.request.AdoptPageRequest;
import com.atyian.pet.admin.pojo.Admin;
import com.atyian.pet.admin.pojo.Adopt;

import java.util.List;

/**
* @author ZHOUYIAN
* @description 针对表【pet_adopt】的数据库操作Mapper
* @createDate 2022-12-16 21:49:23
* @Entity com.atyian.pet.admin.pojo.Adopt
*/
public interface AdoptMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Adopt record);

    int insertSelective(Adopt record);

    Adopt selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Adopt record);

    int updateByPrimaryKey(Adopt record);

    /**
     * 根据条件分页查询信息
     * @param adoptPageRequest
     * @return
     */
    List<Adopt> selectAdoptByCondition(AdoptPageRequest adoptPageRequest);


}
