package com.xzm.video.service.Impl;

import com.xzm.video.bean.*;
import com.xzm.video.constant.ResultCode;
import com.xzm.video.dao.FavoriteMapper;
import com.xzm.video.dao.TagMapper;
import com.xzm.video.dao.TypeMapper;
import com.xzm.video.dao.VideoMapper;
import com.xzm.video.service.TagService;
import com.xzm.video.service.VideoService;
import com.xzm.video.utils.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private TypeMapper typeMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public ResultInfo deleteByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = videoMapper.deleteByPrimaryKey(id);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public ResultInfo insertSelective(Video record,String tags) {
        ResultInfo resultInfo = new ResultInfo(true);
        String tagStr = tags.replaceAll("，",",");
        String[] tagStrs = tagStr.split(",");
        int index = videoMapper.insertSelective(record);
        for(String temp : tagStrs){
            tagMapper.insertSelective(new Tag(temp,index));
        }
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public Video selectByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        Video video = videoMapper.selectByPrimaryKey(id);
        video.setViewnum(video.getViewnum()+1);
        videoMapper.updateByPrimaryKey(video);
        return video;
    }

    @Override
    public ResultInfo updateByPrimaryKeySelective(Video record) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = videoMapper.updateByPrimaryKeySelective(record);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public List<Video> selectAll(){
        return videoMapper.selectAll();
    }

    @Override
    public Map<String,List<Video>> selectNewByType(Integer size){
        Map<String,List<Video>> map = new HashMap();
        List<Type> types = typeMapper.selectAll();
        for(Type type:types){
            List<Video> videos = videoMapper.selectNewByTypeId(type.getId(), size);
            map.put(type.getName(),videos);
        }
        return map;
    }

    @Override
    public Map<String, List<Video>> selectHotByType(Integer size) {
        Map<String,List<Video>> map = new HashMap();
        List<Type> types = typeMapper.selectAll();
        for(Type type:types){
            List<Video> videos = videoMapper.selectHotByTypeId(type.getId(), size);
            map.put(type.getName(),videos);
        }
        return map;
    }

    @Override
    public List<Video> selectHot(Integer size){
        return videoMapper.selectHot(size);
    }

    @Override
    public List<Video> selectByTypeId(Integer type_id) {
        return videoMapper.selectByType(type_id);
    }

    @Override
    public List<Video> selectHotByTypeId(Integer type_id,Integer size) {
        return videoMapper.selectHotByTypeId(type_id,size);
    }

    @Override
    public ResultInfo addFavoriteNum(User user, Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        //检查是否已经收藏
        Favorite favorite = favoriteMapper.selectByUserIdAndVideoId(user.getId(), id);
        Video video = videoMapper.selectByPrimaryKey(id);
        if(favorite!=null){
            favoriteMapper.deleteByPrimaryKey(favorite.getId());
            video.setStarnum(video.getStarnum()-1);
            resultInfo.setCode(ResultCode.CANCEL.getCode());
        }else{
            favorite = new Favorite();
            favorite.setUserId(user.getId());
            Video videoTemp = new Video();
            videoTemp.setId(id);
            favorite.setVideo(videoTemp);
            favorite.setCreateTime(new Date());
            favoriteMapper.insert(favorite);
            video.setStarnum(video.getStarnum()+1);
            resultInfo.setCode(ResultCode.DO.getCode());
        }
        videoMapper.updateByPrimaryKey(video);
        resultInfo.setData("star",video.getStarnum());
        return resultInfo;
    }

    @Override
    public ResultInfo addCoinNum(User user, Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        Video video = videoMapper.selectByPrimaryKey(id);
        video.setCoinnum(video.getCoinnum()+1);
        videoMapper.updateByPrimaryKey(video);
        resultInfo.setData("coin",video.getCoinnum());
        return resultInfo;
    }

    @Override
    public ResultInfo addLikeNum(User user, Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        Video video = videoMapper.selectByPrimaryKey(id);
        video.setLikenum(video.getLikenum()+1);
        videoMapper.updateByPrimaryKey(video);
        resultInfo.setData("like",video.getLikenum());
        return resultInfo;
    }

    @Override
    public List<Video> selectByTitleLike(String query) {
        return videoMapper.selectByTitleLike(query);
    }
}
