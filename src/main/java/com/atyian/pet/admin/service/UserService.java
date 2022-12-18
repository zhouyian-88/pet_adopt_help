package com.atyian.pet.admin.service;

import com.atyian.pet.admin.controller.request.CommonPageRequest;
import com.atyian.pet.admin.controller.request.UserPageRequest;
import com.atyian.pet.admin.pojo.User;
import org.springframework.objenesis.ObjenesisHelper;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-13-22:42
 */
public interface UserService {
    /**
     * 根据条件分页查询用户数据
     * @param commonPageRequest
     * @return
     */
    Object listUserByCondition(CommonPageRequest commonPageRequest);

    /**
     * 创建用户
     * @param user
     * @return
     */
    int createUser(User user);

    /**
     * 根据用户id修改用户信息
     * @param user
     * @return
     */
    int updateUserByUserId(User user);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserByUserId(Long id);

    /**
     * 根据用户id删除用户信息
     * @param id
     * @return
     */
    int deleteUserByUserId(Long id);


    /**
     * 根据用户的真实姓名查询用户
     * @param userName
     * @return
     */
    Object listUserByUserName(String userName);
}
