package com.atyian.pet.admin.service.impl;

import com.atyian.pet.admin.controller.request.CommonPageRequest;
import com.atyian.pet.admin.mapper.UserMapper;
import com.atyian.pet.admin.pojo.User;
import com.atyian.pet.admin.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-13-22:44
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Object listUserByCondition(CommonPageRequest commonPageRequest) {
        System.out.println(commonPageRequest.getPageNum());
        System.out.println(commonPageRequest.getPageSize());
        PageHelper.startPage(commonPageRequest.getPageNum(),commonPageRequest.getPageSize());
        List<User> userList = userMapper.selectAllUserByCondition(commonPageRequest);
        return new PageInfo(userList);
    }

    @Override
    public int createUser(User user) {
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateUserByUserId(User user) {
        user.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User getUserByUserId(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteUserByUserId(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
