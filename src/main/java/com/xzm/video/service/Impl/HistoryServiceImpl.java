package com.xzm.video.service.Impl;

import com.xzm.video.bean.CoinHistory;
import com.xzm.video.bean.History;
import com.xzm.video.bean.LikeHistory;
import com.xzm.video.bean.Video;
import com.xzm.video.dao.CoinHistoryMapper;
import com.xzm.video.dao.HistoryMapper;
import com.xzm.video.dao.LikeHistoryMapper;
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

    @Autowired
    private LikeHistoryMapper likeHistoryMapper;

    @Autowired
    private CoinHistoryMapper coinHistoryMapper;

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

    @Override
    public CoinHistory selectCoinHistoryByUserIdAndVideoId(Integer userId, Integer videoId) {
        return coinHistoryMapper.selectByUserIdAndVideoId(userId,videoId);
    }

    @Override
    public LikeHistory selectLikeHistoryByUserIdAndVideoId(Integer userId, Integer videoId) {
        return likeHistoryMapper.selectByUserIdAndVideoId(userId,videoId);
    }
}
