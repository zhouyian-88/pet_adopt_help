package com.atyian.pet.admin.controller.request;

import lombok.Data;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-16-13:47
 */
@Data
public class PetPageRequest extends BaseRequest {
    private String petName;
    private String petType;

}
