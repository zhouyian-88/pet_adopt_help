package com.atyian.pet.admin.mapper;

import com.atyian.pet.admin.controller.request.CommonPageRequest;
import com.atyian.pet.admin.controller.request.UserPageRequest;
import com.atyian.pet.admin.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author ZHOUYIAN
* @description 针对表【pet_user】的数据库操作Mapper
* @createDate 2022-12-15 09:17:02
* @Entity com.atyian.pet.admin.pojo.User
*/
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据条件进行分页查询
     * @param commonPageRequest
     * @return
     */
    List<User> selectAllUserByCondition(CommonPageRequest commonPageRequest);


    List<User> selectAllUserByUserName(UserPageRequest UserPageRequest);

}
