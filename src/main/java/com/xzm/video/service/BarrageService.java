package com.xzm.video.service;

import com.xzm.video.bean.Barrage;
import com.xzm.video.bean.Video;
import com.xzm.video.utils.ResultInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface BarrageService {

    ResultInfo deleteByPrimaryKey(Integer id);

    ResultInfo insertSelective(Map<String,String> record);

    List<List<Object>> selectByVideoId_api(Integer video_id);

    List<Barrage> selectByVideoId(Integer video_id);

}
