package com.xin.Controller;

import com.alibaba.fastjson.JSONObject;
import com.xin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("/api/v1")
public class LoginController {
   @RequestMapping("login")
    public String login(@RequestBody User user){
       JSONObject jsonObject = new JSONObject();
        if (user.getUsername().equals("admin")&&user.getPassword().equals("123456")){
            jsonObject.put("success",true);
            jsonObject.put("code",200);
            jsonObject.put("message","登录成功");
            jsonObject.put("body",null);
        }else {
            jsonObject.put("success",false);
            jsonObject.put("code",201);
            jsonObject.put("message","用户名或密码错误");
            jsonObject.put("body",null);
        }
        return jsonObject.toJSONString();
    }
}
