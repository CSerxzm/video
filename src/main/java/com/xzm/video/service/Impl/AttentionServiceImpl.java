package com.xzm.video.service.Impl;

import com.xzm.video.bean.Attention;
import com.xzm.video.dao.AttentionMapper;
import com.xzm.video.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-15 15:14
 */

@Service
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    private AttentionMapper attentionMapper;

    @Override
    public Attention selectAttention(Integer userId, Integer attenUserid) {
        return attentionMapper.selectAttention(userId,attenUserid);
    }
}
