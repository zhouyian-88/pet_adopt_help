package com.atyian.pet.admin.controller.request;

import lombok.Data;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-13-22:35
 */
@Data
public class CommonPageRequest extends BaseRequest{
private String nickname;
private String phone;

}
