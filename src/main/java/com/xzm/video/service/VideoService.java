package com.xzm.video.service;

import com.xzm.video.bean.User;
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

    Video selectByPrimaryKeyAdmin(Integer id);

    ResultInfo updateByPrimaryKeySelective(Video record);

    List<Video> selectAll();

    List<Video> selectAllAdmin();

    Map<String,List<Video>> selectNewByType(Integer size);

    Map<String,List<Video>> selectHotByType(Integer size);

    List<Video> selectHot(Integer size);

    List<Video> selectByTypeId(Integer type_id);

    List<Video> selectHotByTypeId(Integer type_id,Integer size);

    /**
     * 获得用户的上传记录
     * @param userId
     * @return
     */
    List<Video> selectByUserId(Integer userId);

    /**
     * 收藏
     * @param id
     * @return
     */
    ResultInfo addFavoriteNum(User user, Integer id);

    /**
     * 投币
     * @param user
     * @param id
     * @return
     */
    ResultInfo addCoinNum(User user,Integer id);

    /**
     * 点赞
     * @param user
     * @param id
     * @return
     */
    ResultInfo addLikeNum(User user,Integer id);

    /**
     * 搜索获得相关的video列表
     * @param query
     * @return
     */
    List<Video> selectByTitleLike(String query);

    /**
     * 用于统计数据
     * @return
     */
    List<Map<String,String>> countByStatus();

    /**
     * 获得用户的投稿数量
     * @param userId
     * @return
     */
    Integer getSumByUserId(Integer userId);

}
