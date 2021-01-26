package com.xzm.video.service;

import com.xzm.video.bean.Type;
import com.xzm.video.utils.ResultInfo;

import java.util.List;

public interface TypeService {

    ResultInfo deleteByPrimaryKey(Integer id);

    ResultInfo insertSelective(Type record);

    Type selectByPrimaryKey(Integer id);

    ResultInfo updateByPrimaryKeySelective(Type record);

    List<Type> selectAll();
}