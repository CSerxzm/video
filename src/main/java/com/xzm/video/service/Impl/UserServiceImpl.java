package com.xzm.video.service.Impl;

import com.xzm.video.bean.User;
import com.xzm.video.dao.UserMapper;
import com.xzm.video.service.UserService;
import com.xzm.video.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        String password = MD5Utils.code(record.getPassword());
        record.setPassword(password);
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        String password = MD5Utils.code(record.getPassword());
        record.setPassword(password);
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User selectForLogin(User record) {
        String password = record.getPassword();
        record.setPassword(MD5Utils.code(password));
        return userMapper.selectForLogin(record);
    }

    @Override
    public User selectByUsername(String username){
        return userMapper.selectByUsername(username);
    }
}
