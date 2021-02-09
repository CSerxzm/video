package com.xzm.video.service.Impl;

import com.xzm.video.bean.Comment;
import com.xzm.video.dao.CommentMapper;
import com.xzm.video.service.CommentService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public ResultInfo deleteByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = commentMapper.deleteByPrimaryKey(id);
        resultInfo.setData("index", index);
        return resultInfo;
    }

    @Override
    public ResultInfo insertSelective(Comment record) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = commentMapper.insertSelective(record);
        record.setId(index);
        resultInfo.setData("comment", record);
        return resultInfo;

    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        Comment comment = commentMapper.selectByPrimaryKey(id);
        return comment;
    }

    @Override
    public ResultInfo updateByPrimaryKeySelective(Comment record) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = commentMapper.updateByPrimaryKeySelective(record);
        resultInfo.setData("index", index);
        return resultInfo;
    }

    @Override
    public List<Comment> selectByVideoId(Integer video_id) {
        return commentMapper.selectByVideoId(video_id);
    }
}
