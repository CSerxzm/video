package com.xzm.video.service;

import com.xzm.video.bean.Comment;
import com.xzm.video.utils.ResultInfo;

import java.awt.*;
import java.util.List;
import java.util.Map;

public interface CommentService {

    ResultInfo deleteByPrimaryKey(Integer id);

    ResultInfo insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    ResultInfo updateByPrimaryKeySelective(Comment record);

    List<Comment> selectByVideoId(Integer video_id);

    List<Comment> selectAllAdmin();

    List<Map<String,String>> countByStatus();

}