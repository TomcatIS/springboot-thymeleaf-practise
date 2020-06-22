package com.dhcc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangqi
 * @date 2020/6/13
 */
@ControllerAdvice
public class ExceptionHandler {

    /*@org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public Map<String, Object> UserNotFoundExceptionHandler(Exception e) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("code", 200);
        map.put("msg", "用户出错了");
        return map;
    }*/

    @org.springframework.web.bind.annotation.ExceptionHandler(UserNotFoundException.class)
    public String UserNotFoundExceptionHandler(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(16);
        map.put("msg", "用户出错了");
        request.setAttribute("javax.servlet.error.status_code", 504);
        return "forward:/error";
    }
}
