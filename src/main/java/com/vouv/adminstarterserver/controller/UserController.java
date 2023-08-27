package com.vouv.adminstarterserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vouv.adminstarterserver.Resp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {


    @PostMapping("/info")
    public Resp info() {
        String demo = "{" +
                "    'roles': ['admin']," +
                "    'introduction': 'I am a super administrator'," +
                "    'avatar': 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif'," +
                "    'name': 'Super Admin'" +
                "  }";
        return Resp.data(JSON.parseObject(demo));
    }

    @PostMapping("/login")
    public Resp login() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token", "admin-token");
        return Resp.data(jsonObject);
    }


    @PostMapping("/logout")
    public Resp logout() {
        return Resp.ok();
    }
}
