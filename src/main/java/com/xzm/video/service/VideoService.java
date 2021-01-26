package com.xzm.video.service;

import com.xzm.video.bean.Video;
import com.xzm.video.utils.ResultInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
public interface VideoService {

    ResultInfo deleteByPrimaryKey(Integer id);

    ResultInfo insertSelective(Video record,String tags);

    Video selectByPrimaryKey(Integer id);

    ResultInfo updateByPrimaryKeySelective(Video record);

    List<Video> selectAll();

    Map<String,List<Video>> selectNewByType(Integer size);

    Map<String,List<Video>> selectHotByType(Integer size);

    List<Video> selectHot(Integer size);

    List<Video> selectByTypeId(Integer type_id);

    List<Video> selectHotByTypeId(Integer type_id,Integer size);

    /**
     * 收藏
     * @param id
     * @return
     */
    ResultInfo addStarNum(Integer id);

    /**
     * 投币
     * @param id
     * @return
     */
    ResultInfo addCoinNum(Integer id);

    /**
     * 点赞
     * @param id
     */
    ResultInfo addLikeNum(Integer id);

}
