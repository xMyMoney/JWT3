package com.example.jwt3.controller;

import com.example.jwt3.entity.RespBean;
import com.example.jwt3.entity.User;
import com.example.jwt3.utils.JWTUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {



    @PostMapping("/login")
    public RespBean login(User user) {
        User userDB = new User("22", "33");
        Map<String, String> payload = new HashMap<>();
        payload.put("id", user.getId());
        payload.put("name", user.getName());
        String token = JWTUtils.getToken(payload);
        return RespBean.ok("登录成功",token);
    }

    @PostMapping()
    public RespBean test(HttpServletRequest request) {

        //TODO 业务逻辑

        return RespBean.ok("请求成功");
    }

}
