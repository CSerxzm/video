package com.xzm.video.dao;

import com.xzm.video.bean.Attention;

public interface AttentionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attention record);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);
}