package com.atyian.pet.admin.service.impl;

import com.atyian.pet.admin.controller.PClassController;
import com.atyian.pet.admin.controller.request.PClassPageRequest;
import com.atyian.pet.admin.mapper.PClassMapper;
import com.atyian.pet.admin.pojo.PClass;
import com.atyian.pet.admin.service.PClassService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.callback.PasswordCallback;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-15-16:29
 */
@Service
public class PClassServiceImpl implements PClassService {
    @Autowired
    private PClassMapper pClassMapper;
    @Override
    public Object listPClassByCondition(PClassPageRequest pClassPageRequest) {
        PageHelper.startPage(pClassPageRequest.getPageNum(), pClassPageRequest.getPageSize());
        List<PClass> pClasses = pClassMapper.selectPClassByCondition(pClassPageRequest);
        return  new PageInfo<>(pClasses);
    }

    @Override
    public int createPClass(PClass pClass) {
        pClass.setCreateTime(new Timestamp(System.currentTimeMillis()));
        return pClassMapper.insertSelective(pClass);
    }

    @Override
    public boolean hasPetType(String petType) {
        PClass pClass = pClassMapper.selectPetType(petType);
        if(pClass!=null){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public PClass getPClassById(Long pkClassId) {
        return pClassMapper.selectByPrimaryKey(pkClassId);
    }

    @Override
    public int updatePClass(PClass pClass) {
        pClass.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        return pClassMapper.updateByPrimaryKeySelective(pClass);
    }

    @Override
    public int deletePClassById(Long pkClassId) {
        return pClassMapper.deleteByPrimaryKey(pkClassId);
    }
}
