package com.xzm.video.constant;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-14 23:42
 */
public enum  ResultCode {

    DO(201,"使用"),CANCEL(202,"取消"),NOTENOUGH(203,"余额不足");

    private Integer code;
    private String name;

    ResultCode() {
    }

    ResultCode(Integer code, String name) {
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
