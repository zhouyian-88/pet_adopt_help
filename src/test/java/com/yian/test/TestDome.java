package com.yian.test;

import com.atyian.pet.admin.controller.request.CommonPageRequest;
import com.atyian.pet.admin.mapper.UserMapper;
import com.atyian.pet.admin.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-13-17:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDome {
    @Autowired
    private UserMapper userService;
    @Test
    public void test(){
        CommonPageRequest commonPageRequest = new CommonPageRequest();
        commonPageRequest.setPageNum(1);
        commonPageRequest.setPageSize(5);
        List<User> users = userService.selectAllUserByCondition(commonPageRequest);
        System.out.println(users);
    }
}
