package com.xzm.video.dao;

import com.xzm.video.bean.CoinHistory;
import org.apache.ibatis.annotations.Param;

public interface CoinHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CoinHistory record);

    int insertSelective(CoinHistory record);

    CoinHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CoinHistory record);

    int updateByPrimaryKey(CoinHistory record);

    CoinHistory selectByUserIdAndVideoId(@Param("userId") Integer userId, @Param("videoId") Integer videoId);
}