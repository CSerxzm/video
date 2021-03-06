package com.xzm.video.dao;

import com.xzm.video.bean.LikeHistory;
import org.apache.ibatis.annotations.Param;

public interface LikeHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LikeHistory record);

    int insertSelective(LikeHistory record);

    LikeHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LikeHistory record);

    int updateByPrimaryKey(LikeHistory record);

    LikeHistory selectByUserIdAndVideoId(@Param("userId") Integer userId, @Param("videoId") Integer videoId);

    Integer deleteByVideoId(Integer videoId);

}