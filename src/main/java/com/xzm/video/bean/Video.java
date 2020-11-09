package com.xzm.video.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Video {
    private Integer id;

    private String title;

    private User user;

    private String description;

    private Date createTime;

    private String videoUrl;

    private Integer viewnum;

    private Integer barrnum;

    private Integer starnum;

    private Integer coinnum;

    private Integer likenum;

    private Integer trannum;

    private Integer typeId;

    private String pictureUrl;

}