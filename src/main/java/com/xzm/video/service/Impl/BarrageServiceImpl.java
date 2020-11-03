package com.xzm.video.service.Impl;

import com.xzm.video.bean.Barrage;
import com.xzm.video.dao.BarrageMapper;
import com.xzm.video.service.BarrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarrageServiceImpl implements BarrageService {

    @Autowired
    BarrageMapper barrageMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return barrageMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Barrage record) {
        return barrageMapper.insert(record);
    }

    @Override
    public int insertSelective(Barrage record) {
        return barrageMapper.insertSelective(record);
    }

    @Override
    public Barrage selectByPrimaryKey(Integer id) {
        return barrageMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Barrage record) {
        return barrageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Barrage record) {
        return 0;
    }
}
