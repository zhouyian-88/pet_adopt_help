package com.atyian.pet.admin.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @TableName pet_adopt
 */
@Data
public class Adopt implements Serializable {
    private Integer pkAdoptId;

    private String petName;

    private Integer petId;

    private String userName;

    private Integer userId;

    private String adminName;

    private Integer adminId;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp updateTime;

    private Integer state;

    private static final long serialVersionUID = 1L;
}