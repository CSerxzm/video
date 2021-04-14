package com.xzm.video.service;

import com.xzm.video.bean.History;

import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-14 15:11
 */
public interface HistoryService {

    /**
     * 添加历史
     * @param userId
     * @param videoId
     * @return
     */
    Integer addHistory(Integer userId,Integer videoId);

    /**
     * 获得用户的所有历史
     * @param userId
     * @return
     */
    List<History> selectAllByUserId(Integer userId);
}
