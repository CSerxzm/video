package com.xzm.video.service.Impl;

import com.xzm.video.bean.History;
import com.xzm.video.bean.Video;
import com.xzm.video.dao.HistoryMapper;
import com.xzm.video.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-14 15:13
 */

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public Integer addHistory(Integer userId, Integer videoId) {
        //删除以前的历史记录
        historyMapper.delHistory(userId,videoId);
        //保存最新的历史记录
        History history = new History();
        history.setUserId(userId);
        history.setCreateTime(new Date());
        Video video = new Video();
        video.setId(videoId);
        history.setVideo(video);
        int insert = historyMapper.insert(history);
        return insert;
    }

    @Override
    public List<History> selectAllByUserId(Integer userId) {
        return historyMapper.selectAllByUserId(userId);
    }
}
