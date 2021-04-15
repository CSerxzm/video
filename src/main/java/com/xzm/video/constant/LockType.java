package com.xzm.video.constant;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-15 9:40
 */

public enum LockType {

    WRITE(1,"写锁"),READ(2,"读锁");

    private Integer code;
    private String name;

    LockType() {
    }

    LockType(Integer code, String name) {
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