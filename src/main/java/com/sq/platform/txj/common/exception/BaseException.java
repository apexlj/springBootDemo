package com.sq.platform.txj.common.exception;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/7 20:06
 */
public class BaseException extends Exception {
    /**
     * 错误码
     */
    private String code;

    public BaseException(){}

    public BaseException(String code) {
        this.code = code;
    }

    public BaseException(String code, Throwable throwable) {
        super(throwable);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    protected void setCode(String code) {
        this.code = code;
    }
}
