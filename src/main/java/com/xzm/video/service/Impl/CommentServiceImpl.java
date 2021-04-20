package com.xzm.video.service.Impl;

import com.xzm.video.bean.Comment;
import com.xzm.video.bean.Video;
import com.xzm.video.constant.Status;
import com.xzm.video.dao.CommentMapper;
import com.xzm.video.dao.VideoMapper;
import com.xzm.video.service.CommentService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public ResultInfo deleteByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = commentMapper.deleteByPrimaryKey(id);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public ResultInfo insertSelective(Comment record) {
        ResultInfo resultInfo = new ResultInfo(true);
        record.setCreateTime(new Date());
        record.setStatus(Status.UNPASS.getCode());
        int index = commentMapper.insertSelective(record);
        resultInfo.setData("index",index);
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
        if(index==1){
            resultInfo.setCode(200);
        }
        return resultInfo;
    }

    @Override
    public List<Comment> selectByVideoId(Integer video_id){
        return commentMapper.selectByVideoId(video_id);
    }

    @Override
    public List<Comment> selectAllAdmin() {
        return commentMapper.selectAllAdmin();
    }

    @Override
    public List<Map<String, String>> countByStatus() {
        return commentMapper.countByStatus();
    }

    @Override
    public Integer countSumByVideoUserId(Integer videoUserId) {
        return commentMapper.countSumByVideoUserId(videoUserId);
    }
}
