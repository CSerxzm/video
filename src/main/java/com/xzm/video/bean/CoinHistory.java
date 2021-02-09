package com.xzm.video.bean;

import java.util.Date;

public class CoinHistory {
    private Integer id;

    private Integer userId;

    private Integer videoId;

    private Integer nums;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public CoinHistory(Integer userId, Integer videoId, Integer nums) {
        this.userId = userId;
        this.videoId = videoId;
        this.nums = nums;
        this.createTime = new Date();
    }
}