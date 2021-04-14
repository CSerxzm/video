package com.xzm.video.bean;

import lombok.Data;

/**
 * 标签
 */
@Data
public class Tag {

    private Integer id;

    private String content;

    private Integer videoId;

    public Tag(){

    }

    public Tag(String content,Integer videoId){
        this.content=content;
        this.videoId=videoId;
    }

}