package com.xzm.video.dao;

import com.xzm.video.bean.LikeHistory;

public interface LikeHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LikeHistory record);

    int insertSelective(LikeHistory record);

    LikeHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LikeHistory record);

    int updateByPrimaryKey(LikeHistory record);
}