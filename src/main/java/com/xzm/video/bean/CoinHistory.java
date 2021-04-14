package com.xzm.video.bean;

import lombok.Data;

import java.util.Date;

/**
 * 投币记录
 */
@Data
public class CoinHistory {
    private Integer id;

    private Integer userId;

    private Integer videoId;

    private Integer nums;

    private Date createTime;

}