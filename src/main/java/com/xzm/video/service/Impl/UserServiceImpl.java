package com.xzm.video.service.Impl;

import com.xzm.video.bean.User;
import com.xzm.video.dao.UserMapper;
import com.xzm.video.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
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
        String username = record.getUsername();
        ByteSource salt = ByteSource.Util.bytes(username);
        Object password = new SimpleHash("MD5",record.getPassword(),salt,2);
        record.setPassword(String.valueOf(password));
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        String username = record.getUsername();
        ByteSource salt = ByteSource.Util.bytes(username);
        Object password = new SimpleHash("MD5",record.getPassword(),salt,2);
        record.setPassword(String.valueOf(password));
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
    public User selectByUsername(String username){
        return userMapper.selectByUsername(username);
    }
}
