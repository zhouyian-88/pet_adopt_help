package com.atyian.pet.admin.pojo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName pet_user
 */
@Data
public class User implements Serializable {
    private Integer pkUserId;

    private String ukUserNickname;

    private String userPassword;

    private String userName;

    private Integer sex;

    private Integer age;

    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String picture;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;

    private String address;

    private Integer experience;

    private Integer state;

    private String remark;

    private static final long serialVersionUID = 1L;
}