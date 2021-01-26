package com.xzm.video.bean;

import lombok.Data;

import java.util.Date;

@Data
public class LikeHistory {
    private Integer id;

    private Integer userId;

    private Integer videoId;

    private Date createTime;
    
}