package com.atyian.pet.admin.controller.request;

import lombok.Data;

/**
 * @athor:zhouhaohui
 * @email:2873642764@qq.com
 * @desc:
 * @datetime:2022-12-04-14:53
 */
@Data
public class BaseRequest {
    private Integer pageNum;//页码为1
    private Integer pageSize;//页码大小
}
