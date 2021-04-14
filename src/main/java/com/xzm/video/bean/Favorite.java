package com.xzm.video.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 收藏记录
 */
@Data
public class Favorite {
    private Integer id;

    private Integer userId;

    private Video video;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

}