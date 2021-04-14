package com.xzm.video.service;

import com.xzm.video.bean.Favorite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-14 18:24
 */
public interface FavoriteService {

    Favorite selectByUserIdAndVideoId(Integer userId,Integer videoId);

    List<Favorite> selectAllByUserId(Integer userId);

}
