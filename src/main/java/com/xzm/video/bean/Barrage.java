package com.xzm.video.bean;

import lombok.Data;

import java.util.Date;

/**
 * 弹幕类
 */
@Data
public class Barrage {
    private Integer id;

    private String text;

    private Date createtime;

    private Integer videoId;

    private String time;

    private User author;

    private Integer color;

    private Integer type;

    private String status;

}