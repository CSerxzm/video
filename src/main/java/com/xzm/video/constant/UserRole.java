package com.xzm.video.constant;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-04-15 16:51
 */
public enum  UserRole {

    ADMIN("admin","管理员"),
    USER("user","用户");

    private String code;

    private String message;

    UserRole() {
    }

    UserRole(String code, String message) {
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
