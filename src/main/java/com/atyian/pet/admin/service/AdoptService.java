package com.atyian.pet.admin.service;

import com.atyian.pet.admin.controller.AdoptController;
import com.atyian.pet.admin.controller.request.AdoptPageRequest;
import com.atyian.pet.admin.pojo.Adopt;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-16-22:00
 */
public interface AdoptService {
   /**
    * 根据条件分页查询收养信息
    * @param adoptPageRequest
    * @return
    */
   Object listAdoptByCondition(AdoptPageRequest adoptPageRequest);

   /**
    * 创建宠物收养信息
    * @param adopt
    * @return
    */
   int createAdopt(Adopt adopt);

   /**
    *  根据id查询收养信息
    * @param adoptId
    * @return
    */
   Adopt getAdoptByAdoptId(Long adoptId);

   /**
    * 根据id修改收养信息
    * @param adopt
    * @return
    */
   int updateAdoptByAdoptId(Adopt adopt);

   /**
    * 根据id删除信息
    * @param adoptId
    * @return
    */
   int deleteAdoptByAdoptId(Long adoptId);

   /**
    * 根据id修改信息
    * @param adoptId
    * @param sign 1表示同意，2表示不同意
    * @return
    */
   int updateAdoptForAgreeAndDisAgree(Long adoptId,Integer sign);
}
