package com.xzm.video.service.Impl;

import com.xzm.video.bean.Type;
import com.xzm.video.dao.TypeMapper;
import com.xzm.video.service.TypeService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService{

    @Autowired
    TypeMapper typeMapper;

    @Override
    public ResultInfo deleteByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = typeMapper.deleteByPrimaryKey(id);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public ResultInfo insertSelective(Type record) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = typeMapper.insertSelective(record);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public Type selectByPrimaryKey(Integer id) {
        Type type = typeMapper.selectByPrimaryKey(id);
        return type;
    }

    @Override
    public ResultInfo updateByPrimaryKeySelective(Type record) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = typeMapper.updateByPrimaryKeySelective(record);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public List<Type> selectAll() {
        return typeMapper.selectAll();
    }
}