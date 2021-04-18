package com.xzm.video.bean;

import lombok.Data;

import java.util.Date;

/**
 * 评论实体类
 */
@Data
public class Comment {
    private Integer id;

    private Integer videoId;

    private User user;

    private Date createTime;

    private String content;

    private String status;

}