package com.xzm.video.service.Impl;

import com.xzm.video.bean.Attention;
import com.xzm.video.bean.User;
import com.xzm.video.constant.ResultCode;
import com.xzm.video.dao.AttentionMapper;
import com.xzm.video.dao.UserMapper;
import com.xzm.video.service.UserService;
import com.xzm.video.utils.ResultInfo;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AttentionMapper attentionMapper;

    @Override
    public ResultInfo deleteByPrimaryKey(Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        int index = userMapper.deleteByPrimaryKey(id);
        resultInfo.setData("index",index);
        return resultInfo;
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
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
    public User updateUser(User user){
        Integer id = user.getId();
        User oldUser = userMapper.selectByPrimaryKey(id);
        if(oldUser.getPassword().equals(user.getPassword())){
            user.setPassword(null);
        }else{
            ByteSource salt = ByteSource.Util.bytes(oldUser.getUsername());
            Object password = new SimpleHash("MD5",user.getPassword(),salt,2);
            user.setPassword(String.valueOf(password));
        }
        int i = userMapper.updateByPrimaryKeySelective(user);
        if(i==1){
            return userMapper.selectByPrimaryKey(id);
        }else{
            return null;

        }
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

    @Override
    public ResultInfo addAttention(User user, Integer id) {
        ResultInfo resultInfo = new ResultInfo(true);
        //检查是否已经关注
        Attention attention = attentionMapper.selectAttention(user.getId(), id);
        User userTemp = userMapper.selectByPrimaryKey(id);
        if(attention!=null){
            attentionMapper.deleteByPrimaryKey(attention.getId());
            userTemp.setAttentionNum(userTemp.getAttentionNum()-1);
            resultInfo.setCode(ResultCode.CANCEL.getCode());
        }else{
            attention = new Attention();
            attention.setUserId(user.getId());
            attention.setAttenUserid(id);
            userTemp.setAttentionNum(userTemp.getAttentionNum()+1);
            attentionMapper.insert(attention);
            resultInfo.setCode(ResultCode.DO.getCode());
        }
        userMapper.updateByPrimaryKey(userTemp);
        resultInfo.setData("attentionNum",userTemp.getAttentionNum());
        return resultInfo;
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<Map<String, String>> countByRole() {
        return userMapper.countByRole();
    }
}
