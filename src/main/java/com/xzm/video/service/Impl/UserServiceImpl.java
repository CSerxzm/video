package com.xzm.video.service.Impl;

import com.xzm.video.bean.User;
import com.xzm.video.dao.UserMapper;
import com.xzm.video.service.UserService;
import com.xzm.video.utils.ResultInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultInfo deleteByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = userMapper.deleteByPrimaryKey(id);
        resultInfo.setData("index",index);
        return resultInfo;
    }


    @Override
    public ResultInfo insertSelective(User record) {
        ResultInfo resultInfo = new ResultInfo(true);
        String username = record.getUsername();
        ByteSource salt = ByteSource.Util.bytes(username);
        Object password = new SimpleHash("MD5",record.getPassword(),salt,2);
        record.setPassword(String.valueOf(password));
        int index = userMapper.insertSelective(record);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @Override
    public ResultInfo updateByPrimaryKeySelective(User record) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = userMapper.updateByPrimaryKeySelective(record);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public ResultInfo selectByUsername(String username){
        ResultInfo resultInfo = new ResultInfo(true);
        User user = userMapper.selectByUsername(username);
        if(user==null){
            return null;
        }
        resultInfo.setData("user",user);
        return resultInfo;
    }
}
