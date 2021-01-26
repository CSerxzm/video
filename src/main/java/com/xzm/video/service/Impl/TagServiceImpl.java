package com.xzm.video.service.Impl;

import com.xzm.video.bean.Tag;
import com.xzm.video.dao.TagMapper;
import com.xzm.video.service.TagService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public ResultInfo deleteByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = tagMapper.deleteByPrimaryKey(id);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public ResultInfo insertSelective(Tag record) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = tagMapper.insertSelective(record);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public Tag selectByPrimaryKey(Integer id) {
        Tag tag = tagMapper.selectByPrimaryKey(id);
        return tag;
    }

    @Override
    public ResultInfo updateByPrimaryKeySelective(Tag record) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = tagMapper.updateByPrimaryKeySelective(record);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public List<Tag> selectByVideoId(Integer videoId) {
        return tagMapper.selectByVideoId(videoId);
    }

}
