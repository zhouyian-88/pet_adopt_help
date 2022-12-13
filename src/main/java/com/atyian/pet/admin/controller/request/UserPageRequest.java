package com.atyian.pet.admin.controller.request;

import lombok.Data;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-12-04-14:55
 */
@Data
public class UserPageRequest extends BaseRequest {
    private String nickname;
    private String phone;
}
