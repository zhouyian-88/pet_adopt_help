package com.atyian.pet.admin.service;

import com.atyian.pet.admin.controller.request.PClassPageRequest;
import com.atyian.pet.admin.pojo.PClass;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-15-16:28
 */
public interface PClassService {
    Object listPClassByCondition(PClassPageRequest pClassPageRequest);

    int createPClass(PClass pClass);

    boolean hasPetType(String petType);


    PClass getPClassById(Long pkClassId);


    int updatePClass(PClass pClass);

    int deletePClassById(Long pkClassId);
}
