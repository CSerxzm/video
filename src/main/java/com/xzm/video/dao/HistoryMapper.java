package com.xzm.video.dao;

import com.xzm.video.bean.History;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(History record);

    int insertSelective(History record);

    History selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(History record);

    int updateByPrimaryKey(History record);

    int delHistory(@Param("userId") Integer userId,@Param("videoId") Integer videoId);

    List<History> selectAllByUserId(Integer userId);

}