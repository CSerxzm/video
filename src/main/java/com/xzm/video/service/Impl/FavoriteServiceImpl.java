package com.xzm.video.service.Impl;

import com.xzm.video.bean.Favorite;
import com.xzm.video.dao.FavoriteMapper;
import com.xzm.video.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-14 18:25
 */

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public Favorite selectByUserIdAndVideoId(Integer userId, Integer videoId) {
        return favoriteMapper.selectByUserIdAndVideoId(userId,videoId);
    }

    @Override
    public List<Favorite> selectAllByUserId(Integer userId) {
        return favoriteMapper.selectAllByUserId(userId);
    }
}
