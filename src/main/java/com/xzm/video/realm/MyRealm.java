package com.xzm.video.realm;

import com.xzm.video.bean.User;
import com.xzm.video.dao.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.relation.Role;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        User user = (User) principalCollection.getPrimaryPrincipal();
        //添加角色和权限
        System.out.println(user);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(String.valueOf(user.getRole()));
        return simpleAuthorizationInfo;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获得用户名
        String userName = (String)authenticationToken.getPrincipal();

        //2查询数据库
        User user = userMapper.selectByUsername(userName);
        if (user == null){
            return null;
        }
        ByteSource salt = ByteSource.Util.bytes(userName);

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo
                (user,user.getPassword(),salt,"myRealm");

        return authenticationInfo;
    }
}
