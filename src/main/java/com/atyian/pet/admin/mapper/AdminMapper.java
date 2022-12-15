package com.atyian.pet.admin.mapper;

import com.atyian.pet.admin.controller.request.CommonPageRequest;
import com.atyian.pet.admin.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-12-02-15:36
 */
@Mapper
public interface AdminMapper {
    /**
     * 通过昵称和密码查询用户信息，用于登入验证
     * @param nickname
     * @param password
     * @return
     */
   // @Select("select * from pet_admin where uk_admin_nickname = #{nickname} and admin_password = #{password}")
    Admin selectForOne(@Param("nickname") String nickname,@Param("password") String password);

    /**
     * 添加管理员信息
     * @param admin
     * @return
     */
    int insertAdmin(Admin admin);

    /**
     * 根据条件分页查询管理员信息
     * @param adminPageRequest
     * @return
     */
    List<Admin> listByCondition(CommonPageRequest adminPageRequest);


    /**
     * 根据修改管理员信息
     * @param admin
     * @return
     */
    int updateByPrimaryKey(Admin admin);

    /**
     * 根据主键为条件查询管理员信息
     * @param id
     * @return
     */
    Admin selectAdminByPrimaryKey(Integer id);

    /**
     * 根据主键删除管理员信息
     * @param id
     * @return
     */
    int deleteAdminByPrimaryKey(Integer id);
}
