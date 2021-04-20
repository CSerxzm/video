package com.xzm.video.service;

import com.xzm.video.bean.User;
import com.xzm.video.utils.ResultInfo;

import java.util.List;
import java.util.Map;

public interface UserService {

    ResultInfo deleteByPrimaryKey(Integer id);

    int deleteUser(Integer id);

    ResultInfo insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    ResultInfo updateByPrimaryKeySelective(User record);

    ResultInfo selectByUsername(String username);

    ResultInfo addAttention(User user, Integer id);

    List<User> selectAll();

    User updateUser(User user);

    List<Map<String,String>> countByRole();
}