package com.xzm.video.bean;

import lombok.Data;

@Data
public class Favorite {
    private Integer id;

    private Integer userId;

    private Integer videoId;

    public Integer getId() {
        return id;
    }

}