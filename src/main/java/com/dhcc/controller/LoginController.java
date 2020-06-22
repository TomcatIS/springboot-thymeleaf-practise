package com.dhcc.controller;

import com.dhcc.exception.UserNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author zhangqi
 * @date 2020/6/4
 */
@Controller
@RequestMapping("user")
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Map<String, String> map, HttpSession session) {
        if ("admin".equals(username) && "admin".equals(password)) {
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }
        if ("guest".equals(username) && "guest".equals(password)) {
            throw new UserNotFoundException();
        }
        map.put("msg", "用户名或密码错误");
        return "login";

        //直接访问dashboard，拦截，通过session判断是否登录
        //已登录就放心
        //未登录就重定向到首页
    }
}
