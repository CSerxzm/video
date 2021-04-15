package com.xzm.video.service;

import com.xzm.video.bean.User;
import com.xzm.video.utils.ResultInfo;

public interface UserService {

    ResultInfo deleteByPrimaryKey(Integer id);

    ResultInfo insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    ResultInfo updateByPrimaryKeySelective(User record);

    ResultInfo selectByUsername(String username);

    ResultInfo addAttention(User user, Integer id);
}