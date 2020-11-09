package com.xzm.video.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Barrage {
    private Integer id;

    private String text;

    private Date createtime;

    private Integer videoId;

    private String time;

    private Integer author;

    private Integer color;

    private Integer type;

}