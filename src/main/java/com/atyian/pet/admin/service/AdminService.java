package com.atyian.pet.admin.service;

import com.atyian.pet.admin.controller.request.UserPageRequest;
import com.atyian.pet.admin.pojo.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-12-02-15:40
 */
public interface AdminService {

    Admin selectForOne(String nickname, String password);

    int create(Admin admin);

    Object listByCondition(UserPageRequest userPageRequest);

    int updateByPrimaryKey(Admin admin);

    Admin getAdminByPrimaryKey(Integer id);

    int deleteAdminByPrimaryKey(Integer id);
}
