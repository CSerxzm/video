package com.xzm.video.dao;

import com.xzm.video.bean.Barrage;

public interface BarrageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    Barrage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);
}