package com.xzm.video.constant;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-15 10:22
 */
public enum LockName {

    FAVORITE(1,"收藏");

    private Integer code;
    private String name;

    LockName() {
    }

    LockName(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
