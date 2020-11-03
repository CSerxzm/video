package com.xzm.video.service.Impl;

import com.xzm.video.bean.Type;
import com.xzm.video.bean.Video;
import com.xzm.video.dao.TypeMapper;
import com.xzm.video.dao.VideoMapper;
import com.xzm.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VideoServiceImpl implements VideoService{

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    TypeMapper typeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return videoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Video record) {
        return videoMapper.insert(record);
    }

    @Override
    public int insertSelective(Video record) {
        return videoMapper.insertSelective(record);
    }

    @Override
    public Video selectByPrimaryKey(Integer id) {
        return videoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Video record) {
        return videoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Video record) {
        return videoMapper.updateByPrimaryKey(record);
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
    public List<Video> selectByType(Integer type_id) {
        return videoMapper.selectByType(type_id);
    }
}
