package com.xzm.video.dao;

import com.xzm.video.bean.Attention;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttentionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attention record);

    int insertSelective(Attention record);

    Attention selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);

    Attention selectAttention(@Param("userId") Integer userId, @Param("attenUserid") Integer attenUserid);

    /**
     * 获得用户的关注列表
     * @param userId
     * @return
     */
    List<Attention> selectByUserId(Integer userId);

    /**
     * 获得用户的粉丝列表
     * @param attenUserid
     * @return
     */
    List<Attention> selectByAttenUserId(Integer attenUserid);

    /**
     * 获得用户的粉丝数
     * @param attenUserid
     * @return
     */
    Integer countSumByAttenUserId(Integer attenUserid);

    /**
     * 获得用户的关注数
     * @param userId
     * @return
     */
    Integer countSumByUserId(Integer userId);
}