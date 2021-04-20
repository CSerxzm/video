package com.xzm.video.bean;

import lombok.Data;

/**
 * 这个只是用于返回
 * 应用场景：
 *  已知用户标识，获得它的关注作者;
 *  已知用户标识，获得它的粉丝列表
 */
@Data
public class AttentionVo {

    private Integer id;

    private Integer userId;

    private User user;

}