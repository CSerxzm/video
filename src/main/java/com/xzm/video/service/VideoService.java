package com.xzm.video.service;

import com.xzm.video.bean.Video;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface VideoService {

    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    List<Video> selectAll();

    Map<String,List<Video>> selectNewByType(Integer size);

    Map<String,List<Video>> selectHotByType(Integer size);

    List<Video> selectHot(Integer size);

    List<Video> selectByType(Integer type_id);
}
