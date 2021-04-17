package com.xzm.video.service;

import com.xzm.video.bean.User;
import com.xzm.video.utils.ResultInfo;

import java.util.List;

public interface UserService {

    ResultInfo deleteByPrimaryKey(Integer id);

    int deleteUser(Integer id);

    ResultInfo insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    ResultInfo updateByPrimaryKeySelective(User record);

    ResultInfo selectByUsername(String username);

    ResultInfo addAttention(User user, Integer id);

    List<User> selectAll();

    int updateUser(User user);
}