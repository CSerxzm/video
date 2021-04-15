package com.xzm.video.service;

import com.xzm.video.bean.Attention;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-15 15:13
 */
public interface AttentionService {

    Attention selectAttention(Integer userId, Integer attenUserid);

}
