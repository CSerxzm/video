package com.xzm.video.service;

import com.xzm.video.bean.Barrage;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BarrageService {

    int deleteByPrimaryKey(Integer id);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    Barrage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Barrage record);

    int updateByPrimaryKey(Barrage record);

}
