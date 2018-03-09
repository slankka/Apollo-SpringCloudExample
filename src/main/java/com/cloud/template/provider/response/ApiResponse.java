package com.cloud.template.provider.response;

import com.alibaba.fastjson.JSONObject;
import com.cloud.template.domain.enums.BizExceptionEnum;

import java.io.Serializable;

/**
 *
 *
 * 返回的数据格式
 */
public class ApiResponse<T> implements Serializable {
    private static final long serialVersionUID = -2465140747749709626L;
    private boolean success;
    private int code;
    private String msg;
    private T data;

    public ApiResponse() {
    }


    private static<T> ApiResponse build(T data, boolean isSuccess, int code, String msg) {
        ApiResponse<T> response = new ApiResponse<>();
        response.setData(data);
        response.setSuccess(isSuccess);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static<T> ApiResponse buildSuccess(T data) {
        return build(data, true, BizExceptionEnum.SUCCESS.getCode(), BizExceptionEnum.SUCCESS.getError());
    }

    public static ApiResponse buildSuccess() {
        return build(null, true, BizExceptionEnum.SUCCESS.getCode(), BizExceptionEnum.SUCCESS.getError());
    }

    public static ApiResponse buildFailure() {
        return build(null, false, BizExceptionEnum.UNKNOWN_ERROR.getCode(), BizExceptionEnum.UNKNOWN_ERROR.getError());
    }

    public static ApiResponse buildFailure(String errorMsg) {
        return build(null, false, BizExceptionEnum.UNKNOWN_ERROR.getCode(), errorMsg);
    }

    public static ApiResponse buildFailure(BizExceptionEnum bizExceptionEnum) {
        return build(null, false, bizExceptionEnum.getCode(), bizExceptionEnum.getError());
    }

    public static ApiResponse buildFailure(int errorCode, String errorMsg) {
        return build(null, false, errorCode, errorMsg);
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toJsonString() {
        JSONObject jo = new JSONObject();
        jo.put("msg", this.getMsg());
        jo.put("code", this.getCode());
        jo.put("data", this.getData());
        return jo.toJSONString();
    }
}