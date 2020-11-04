package com.xzm.video.service;

import com.xzm.video.bean.Barrage;
import com.xzm.video.bean.Video;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface BarrageService {

    int deleteByPrimaryKey(Integer id);

    int insert(Map<String,String> record);

    int insertSelective(Map<String,String> record);

    Barrage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);

    List<List<Object>> selectByVideoId_api(Integer video_id);

    List<Barrage> selectByVideoId(Integer video_id);

}
