package com.xzm.video.service;

import com.xzm.video.bean.Tag;
import com.xzm.video.utils.ResultInfo;

import java.util.List;

public interface TagService {

    ResultInfo deleteByPrimaryKey(Integer id);

    ResultInfo insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    ResultInfo updateByPrimaryKeySelective(Tag record);

    /**
     * 通过blog标识查找所有的标签
     *
     * @param videoId
     * @return
     */
    List<Tag> selectByVideoId(Integer videoId);
}