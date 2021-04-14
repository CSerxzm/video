package com.xzm.video.bean;

import lombok.Data;

/**
 * 用户的关注列表
 */
@Data
public class Attention {
    private Integer id;

    private Integer userId;

    private Integer attenUserid;

}