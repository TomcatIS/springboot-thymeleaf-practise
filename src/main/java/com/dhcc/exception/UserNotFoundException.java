package com.dhcc.exception;

/**
 * @author zhangqi
 * @date 2020/6/13
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("用户不存在！");
    }
}
