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

    private Integer viewnum;//观看数

    private Integer barrnum;//弹幕数

    private Integer starnum;//收藏数

    private Integer coinnum;//投币数

    private Integer likenum;//点赞数

    private Integer trannum;//转发数

    private Integer typeId;

    private String pictureUrl;
    
}