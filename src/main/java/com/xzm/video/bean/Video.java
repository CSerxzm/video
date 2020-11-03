package com.xzm.video.bean;

import java.util.Date;

public class Video {
    private Integer id;

    private String title;

    private User user;

    private String description;

    private Date createTime;

    private String videoUrl;

    private Integer viewnum;

    private Integer barrnum;

    private Integer starnum;

    private Integer coinnum;

    private Integer likenum;

    private Integer trannum;

    private Integer typeId;

    private String pictureUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getViewnum() {
        return viewnum;
    }

    public void setViewnum(Integer viewnum) {
        this.viewnum = viewnum;
    }

    public Integer getBarrnum() {
        return barrnum;
    }

    public void setBarrnum(Integer barrnum) {
        this.barrnum = barrnum;
    }

    public Integer getStarnum() {
        return starnum;
    }

    public void setStarnum(Integer starnum) {
        this.starnum = starnum;
    }

    public Integer getCoinnum() {
        return coinnum;
    }

    public void setCoinnum(Integer coinnum) {
        this.coinnum = coinnum;
    }

    public Integer getLikenum() {
        return likenum;
    }

    public void setLikenum(Integer likenum) {
        this.likenum = likenum;
    }

    public Integer getTrannum() {
        return trannum;
    }

    public void setTrannum(Integer trannum) {
        this.trannum = trannum;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}