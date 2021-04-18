package com.xzm.video.constant;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-17 19:18
 */
public enum Status {

    PASS("1","审核通过"),
    UNPASS("0","审核不通过");

    private String code;

    private String message;

    Status() {
    }

    Status(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
