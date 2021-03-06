package com.xzm.video.dao;

import com.xzm.video.bean.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface VideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Video record);

    int insertSelective(Video record);

    Video selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Video record);

    int updateByPrimaryKey(Video record);

    List<Video> selectAll();

    List<Video> selectNewByTypeId(@Param("type_id") Integer type_id, @Param("size") Integer size);

    List<Video> selectHotByTypeId(@Param("type_id") Integer type_id, @Param("size") Integer size);

    List<Video> selectHot(Integer size);

    List<Video> selectByType(Integer type_id);

    List<Video> selectByTitleLike(@Param("query") String query);

    List<Video> selectAllAdmin();

    List<Map<String,String>> countByStatus();

    /**
     * 获得用户的上传记录
     * @param userId
     * @return
     */
    List<Video> selectByUserId(Integer userId);

    /**
     * 获得用户的上传数量
     * @param userId
     * @return
     */
    Integer getSumByUserId(Integer userId);
}