package com.atyian.pet.admin.controller.request;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author: yianzhou
 * @email: 2873642764@qq.com
 * @desc:
 * @datetime: 2022-12-16-21:54
 */
@Data
public class AdoptPageRequest extends BaseRequest{
    private String userName;
    private String petName;
    private String createTime;
    private Integer state;
}
