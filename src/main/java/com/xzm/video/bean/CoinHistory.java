package com.xzm.video.bean;

import lombok.Data;

import java.util.Date;

@Data
public class CoinHistory {
    private Integer id;

    private Integer userId;

    private Integer videoId;

    private Integer nums;

    private Date createTime;

}