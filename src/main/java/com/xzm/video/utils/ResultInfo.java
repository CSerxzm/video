package com.xzm.video.utils;

import org.codehaus.plexus.util.ExceptionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiangzhimin
 * @Description 结果返回集合
 * @create 2021-01-25 9:47
 */

public class ResultInfo {

    /**
     * 操作成功
     */
    protected boolean success = false;

    /**
     * 结果代码。用来存储表示特殊含义的信息
     */
    protected Integer code = null;

    /**
     * 结果信息。一般为错误信息
     */
    protected String message = null;

    /**
     * 结果数据
     */
    protected Map<String, Object> data = new HashMap<String, Object>();

    /**
     * 消息提示类型，1-alert;2-confirm;3-noTip
     */
    protected Integer tipType = 1;

    /**
     * 异常时的堆栈信息（开发环境）
     */
    protected Object StackTrace = null;

    /**
     * 异常时的堆栈信息（开发环境）
     */
    private List<String> strings;

    public ResultInfo() {
    }

    public ResultInfo(boolean success) {
        this();
        this.success = success;
    }

    public ResultInfo(String key, Object object) {
        this();
        this.success = true;
        this.data.put(key, object);
    }

    public ResultInfo(boolean success, String key, Object object) {
        this();
        this.success = success;
        this.data.put(key, object);
    }

    public ResultInfo(boolean success, String key1, Object object1, String key2, Object object2) {
        this();
        this.success = success;
        this.data.put(key1, object1);
        this.data.put(key2, object2);
    }


    public ResultInfo(int code) {
        this();
        this.code = code;
    }

    public ResultInfo(boolean success, int code) {
        this();
        this.success = success;
        this.code = code;
    }

    public ResultInfo(boolean success, int code, String message) {
        this();
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public ResultInfo(boolean success, String message) {
        this();
        this.success = success;
        this.message = message;
    }

    public ResultInfo(boolean success, String message, Map<String, Object> data) {
        this();
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ResultInfo(boolean success, String message, String key, Object object) {
        this.success = success;
        this.message = message;
        this.data.put(key, object);
    }

    public ResultInfo(Exception e) {
        this.success = false;
        this.message = e.getMessage();
        this.StackTrace = ExceptionUtils.getFullStackTrace(e);
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public void setData(String key, Object data) {
        this.data.put(key, data);
    }

    public void addData(String key, Object data) {
        this.data.put(key, data);
    }

    public Object getData(String key) {
        return data.get(key);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getTipType() {
        return tipType;
    }

    public void setTipType(Integer tipType) {
        this.tipType = tipType;
    }

    public Object getStackTrace() {
        return StackTrace;
    }

    public void setStackTrace(Object stackTrace) {
        StackTrace = stackTrace;
    }

    public List<String> getStrings() {
        return strings;
    }

    public void setStrings(List<String> strings) {
        this.strings = strings;
    }

}
