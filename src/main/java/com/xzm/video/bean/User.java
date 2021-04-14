package com.xzm.video.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 */
@Data
public class User {
    private Integer id;

    private String username;

    private String description;

    private transient String password;

    private String nickname;

    private String avatar;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private Integer coinnum;

    private transient String role;

}