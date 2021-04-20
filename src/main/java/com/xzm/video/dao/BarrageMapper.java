package com.xzm.video.dao;

import com.xzm.video.bean.Barrage;

import java.util.List;
import java.util.Map;

public interface BarrageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    Barrage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);

    List<Barrage> selectByVideoId(Integer video_id);

    List<Barrage> selectAllAdmin();

    List<Map<String,String>> countByStatus();

    Integer countSumByVideoUserId(Integer videoUserId);

    Integer deleteByVideoId(Integer videoId);

}