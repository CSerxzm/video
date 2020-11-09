package com.xzm.video.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Integer id;

    private Integer videoId;

    private User user;

    private Date createTime;

    private String content;

}