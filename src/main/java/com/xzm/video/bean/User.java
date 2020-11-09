package com.xzm.video.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String username;

    private String description;

    private String password;

    private String nickname;

    private String avatar;

    private Date createTime;

    private Integer coinnum;

    private String role;

}