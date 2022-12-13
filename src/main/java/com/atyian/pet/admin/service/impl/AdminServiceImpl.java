package com.atyian.pet.admin.service.impl;

import com.atyian.pet.admin.controller.request.UserPageRequest;
import com.atyian.pet.admin.mapper.AdminMapper;
import com.atyian.pet.admin.pojo.Admin;
import com.atyian.pet.admin.service.AdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;


/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-12-02-15:41
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin selectForOne(String nickname, String password) {
        Admin admin = adminMapper.selectForOne(nickname, password);
        return admin;
    }

    @Override
    public int create(Admin admin) {
        admin.setPkAdminId(null);
        admin.setCreateTime(new Timestamp(System.currentTimeMillis()));
        admin.setUpdateTime(null);
        admin.setState(1);
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public Object listByCondition(UserPageRequest userPageRequest) {
        PageHelper.startPage(userPageRequest.getPageNum(),userPageRequest.getPageSize());
        List<Admin> admin = adminMapper.listByCondition(userPageRequest);
        return new PageInfo<>(admin);
    }

    @Override
    public int updateByPrimaryKey(Admin admin) {
        admin.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return adminMapper.updateByPrimaryKey(admin);
    }

    @Override
    public Admin getAdminByPrimaryKey(Integer id) {
        return adminMapper.selectAdminByPrimaryKey(id);
    }

    @Override
    public int deleteAdminByPrimaryKey(Integer id) {
        return adminMapper.deleteAdminByPrimaryKey(id);
    }
}
