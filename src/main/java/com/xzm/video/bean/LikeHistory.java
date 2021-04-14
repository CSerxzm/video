package com.xzm.video.bean;

import lombok.Data;

import java.util.Date;

/**
 * 点赞记录
 */
@Data
public class LikeHistory {
    private Integer id;

    private Integer userId;

    private Integer videoId;

    private Date createTime;
    
}