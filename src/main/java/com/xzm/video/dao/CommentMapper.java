package com.xzm.video.dao;

import com.xzm.video.bean.Comment;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> selectByVideoId(Integer video_id);

    List<Comment> selectAllAdmin();

    List<Map<String,String>> countByStatus();
}