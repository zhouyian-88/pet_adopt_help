package com.atyian.pet.admin.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName pet_pet
 */
@Data
public class Pet implements Serializable {
    private Integer pkPetId;

    private String petName;

    private String petType;

    private Integer sex;

    private Integer age;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String picture;

    private String remark;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;

    private Integer state;

    private static final long serialVersionUID = 1L;
}