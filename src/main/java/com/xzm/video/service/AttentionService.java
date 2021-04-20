package com.xzm.video.service;

import com.xzm.video.bean.Attention;

import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-15 15:13
 */
public interface AttentionService {

    /**
     * 查看两者之间是否有关注与被关注关系
     * @param userId
     * @param attenUserid
     * @return
     */
    Attention selectAttention(Integer userId, Integer attenUserid);

    /**
     * 获得用户的关注列表
     * @param userId
     * @return
     */
    List<Attention> selectByUserId(Integer userId);

    /**
     * 获得用户的粉丝列表
     * @param attenUserid
     * @return
     */
    List<Attention> selectByAttenUserId(Integer attenUserid);

    /**
     * 获得用户的关注数量
     * @param userId
     * @return
     */
    Integer countSumByUserId(Integer userId);

    /**
     * 获得用户的粉丝数量
     * @param attenUserid
     * @return
     */
    Integer countSumByAttenUserId(Integer attenUserid);
}
