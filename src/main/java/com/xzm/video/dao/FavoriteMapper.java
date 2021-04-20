package com.xzm.video.dao;

import com.xzm.video.bean.Favorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavoriteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Favorite record);

    int insertSelective(Favorite record);

    Favorite selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Favorite record);

    int updateByPrimaryKey(Favorite record);

    Favorite selectByUserIdAndVideoId(@Param("userId") Integer userId, @Param("videoId") Integer videoId);

    List<Favorite> selectAllByUserId(Integer userId);

    Integer deleteByVideoId(Integer videoId);

}