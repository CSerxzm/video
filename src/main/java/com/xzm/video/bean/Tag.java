package com.xzm.video.bean;

import lombok.Data;

@Data
public class Tag {

    private Integer id;

    private String content;

    private Integer videoId;

    public Tag() {

    }

    public Tag(String content, Integer videoId) {
        this.content = content;
        this.videoId = videoId;
    }

}