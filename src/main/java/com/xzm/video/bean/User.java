package com.xzm.video.bean;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String description;

    private String password;

    private String nickname;

    private String avatar;

    private Date createTime;

    private Integer coinnum;

    private Integer usertype;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(Integer id, String username, String description, String password, String nickname, String avatar, Date createTime, Integer coinnum, Integer usertype) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.password = password;
        this.nickname = nickname;
        this.avatar = avatar;
        this.createTime = createTime;
        this.coinnum = coinnum;
        this.usertype = usertype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCoinnum() {
        return coinnum;
    }

    public void setCoinnum(Integer coinnum) {
        this.coinnum = coinnum;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }
}