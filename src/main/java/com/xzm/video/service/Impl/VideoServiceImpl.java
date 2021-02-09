package com.xzm.video.service.Impl;

import com.xzm.video.bean.*;
import com.xzm.video.dao.CoinHistoryMapper;
import com.xzm.video.dao.TagMapper;
import com.xzm.video.dao.TypeMapper;
import com.xzm.video.dao.VideoMapper;
import com.xzm.video.service.TagService;
import com.xzm.video.service.VideoService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    TypeMapper typeMapper;

    @Autowired
    TagMapper tagMapper;

    @Autowired
    CoinHistoryMapper coinHistoryMapper;

    @Override
    public ResultInfo deleteByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = videoMapper.deleteByPrimaryKey(id);
        resultInfo.setData("index", index);
        return resultInfo;
    }

    @Override
    public ResultInfo insertSelective(Video record, String tags) {
        ResultInfo resultInfo = new ResultInfo(true);
        String tagStr = tags.replaceAll("，", ",");
        String[] tagStrs = tagStr.split(",");
        int index = videoMapper.insertSelective(record);
        for (String temp : tagStrs) {
            tagMapper.insertSelective(new Tag(temp, index));
        }
        resultInfo.setData("index", index);
        return resultInfo;
    }

    @Override
    public Video selectByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        Video video = videoMapper.selectByPrimaryKey(id);
        video.setViewnum(video.getViewnum() + 1);
        videoMapper.updateByPrimaryKey(video);
        return video;
    }

    @Override
    public ResultInfo updateByPrimaryKeySelective(Video record) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = videoMapper.updateByPrimaryKeySelective(record);
        resultInfo.setData("index", index);
        return resultInfo;
    }

    @Override
    public List<Video> selectAll() {
        return videoMapper.selectAll();
    }

    @Override
    public Map<String, List<Video>> selectNewByType(Integer size) {
        Map<String, List<Video>> map = new HashMap();
        List<Type> types = typeMapper.selectAll();
        for (Type type : types) {
            List<Video> videos = videoMapper.selectNewByTypeId(type.getId(), size);
            map.put(type.getName(), videos);
        }
        return map;
    }

    @Override
    public Map<String, List<Video>> selectHotByType(Integer size) {
        Map<String, List<Video>> map = new HashMap();
        List<Type> types = typeMapper.selectAll();
        for (Type type : types) {
            List<Video> videos = videoMapper.selectHotByTypeId(type.getId(), size);
            map.put(type.getName(), videos);
        }
        return map;
    }

    @Override
    public List<Video> selectHot(Integer size) {
        return videoMapper.selectHot(size);
    }

    @Override
    public List<Video> selectByTypeId(Integer type_id) {
        return videoMapper.selectByType(type_id);
    }

    @Override
    public List<Video> selectHotByTypeId(Integer type_id, Integer size) {
        return videoMapper.selectHotByTypeId(type_id, size);
    }

    @Override
    public ResultInfo addStarNum(HttpSession session, Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        Video video = videoMapper.selectByPrimaryKey(id);
        video.setStarnum(video.getStarnum() + 1);
        videoMapper.updateByPrimaryKey(video);
        resultInfo.setData("star", video.getStarnum());
        return resultInfo;
    }

    @Override
    public ResultInfo addCoinNum(HttpSession session, Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        User user = (User) session.getAttribute("user");
        CoinHistory coinHistory = coinHistoryMapper.selectHistoryById(user.getId(), id);
        if (coinHistory != null) {
            resultInfo.setSuccess(false);
            resultInfo.setMessage("此视频你已经投币。");
        } else {
            coinHistoryMapper.insertSelective(new CoinHistory(user.getId(), id, 1));
            Video video = videoMapper.selectByPrimaryKey(id);
            video.setCoinnum(video.getCoinnum() + 1);
            videoMapper.updateByPrimaryKey(video);
            resultInfo.setData("coin", video.getCoinnum());
        }
        return resultInfo;
    }

    @Override
    public ResultInfo addLikeNum(HttpSession session, Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        Video video = videoMapper.selectByPrimaryKey(id);
        video.setLikenum(video.getLikenum() + 1);
        videoMapper.updateByPrimaryKey(video);
        resultInfo.setData("like", video.getLikenum());
        return resultInfo;
    }

}
