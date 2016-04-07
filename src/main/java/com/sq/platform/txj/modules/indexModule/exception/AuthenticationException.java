package com.sq.platform.txj.modules.indexModule.exception;

/**
 * @author lijiang
 * @version 1.0
 * @date 2016/4/7 20:13
 */
public class AuthenticationException extends UserServiceException {
    public AuthenticationException() {
        setCode(UserServiceErrorCode.AUTH_ERROR);
    }
}
