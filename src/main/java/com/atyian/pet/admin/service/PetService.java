package com.atyian.pet.admin.service;

import com.atyian.pet.admin.controller.request.PetPageRequest;
import com.atyian.pet.admin.pojo.PClass;
import com.atyian.pet.admin.pojo.Pet;

import java.util.List;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-16-13:51
 */
public interface PetService {
    Object listPetByCondition(PetPageRequest petPageRequest);

    Object listPClassByPetType(String petType);

    int createPet(Pet pet);

    int updatePetByPetId(Pet pet);

    Pet getPetByPetId(Long petId);

    int deletePetByPetId(Long petId);
}
