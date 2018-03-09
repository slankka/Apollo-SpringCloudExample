package com.cloud.template.domain.exception;


import com.cloud.template.domain.enums.BizExceptionEnum;

@SuppressWarnings("unused")
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -449021693040291621L;

    private Integer code;
    private String msg;

    /**
     * 错误枚举
     **/
    private BizExceptionEnum errorDtlEnum;

    /**
     * 详细错误信息
     **/
    private String detailErrorMsg;


    /**
     * 构造方法
     *
     * @param errorDtlEnum 错误枚举
     */
    public BizException(BizExceptionEnum errorDtlEnum) {
        this.errorDtlEnum = errorDtlEnum;
    }

    public BizException(BizExceptionEnum errorDtlEnum, String detailErrorMsg) {
        this.errorDtlEnum = errorDtlEnum;
        this.detailErrorMsg = detailErrorMsg;
    }

    public BizException(BizExceptionEnum errorDtlEnum, Throwable throwable){
        super(throwable);
        this.errorDtlEnum = errorDtlEnum;
    }

    private BizException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public BizExceptionEnum getErrorDtlEnum() {
        return errorDtlEnum;
    }

    public void setErrorDtlEnum(BizExceptionEnum errorDtlEnum) {
        this.errorDtlEnum = errorDtlEnum;
    }

    public String getDetailErrorMsg() {
        return detailErrorMsg;
    }

    public void setDetailErrorMsg(String detailErrorMsg) {
        this.detailErrorMsg = detailErrorMsg;
    }

    public static BizException build(Integer code, String msg){
        return new BizException(code,msg);
    }

    public static BizException build(BizExceptionEnum exceptionEnum){
        return new BizException(exceptionEnum.getCode(),exceptionEnum.getError());
    }

}
