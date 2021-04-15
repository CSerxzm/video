package com.xzm.video.dao;

import com.xzm.video.bean.Attention;
import org.apache.ibatis.annotations.Param;

public interface AttentionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attention record);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);

    Attention selectAttention(@Param("userId") Integer userId, @Param("attenUserid") Integer attenUserid);
}