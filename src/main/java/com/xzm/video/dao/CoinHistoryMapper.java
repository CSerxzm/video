package com.xzm.video.dao;

import com.xzm.video.bean.CoinHistory;

public interface CoinHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoinHistory record);

    int insertSelective(CoinHistory record);

    CoinHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoinHistory record);

    int updateByPrimaryKey(CoinHistory record);

    CoinHistory selectHistoryById(Integer userId, Integer videoId);
}