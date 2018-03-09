package com.cloud.template.domain.enums;

/**
 *
 *
 * 业务异常
 */
public enum BizExceptionEnum {
    SUCCESS                         (200, "success"),
    PARAM_ERROR                     (90001, "参数不正确"),
    UNKNOWN_ERROR                   (90002, "未知异常"),
    REQUEST_PARAM_BLANK             (90003, "请求参数不能为空"),
    REQUEST_PARAM_NOT_ENOUGH        (90004, "请求参数不够，或者不正确"),
    UPSTREAM_FAIL                   (70001, "Service Unavailable: UPSTREAM_FAIL"),
    ;

    private Integer code;
    private String error;


    BizExceptionEnum(Integer code, String error) {
        this.code = code;
        this.error = error;
    }

    public Integer getCode() {
        return code;
    }

    public String getError() {
        return error;
    }

}
