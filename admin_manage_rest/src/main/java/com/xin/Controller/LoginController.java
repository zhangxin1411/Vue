package com.xin.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xin.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;


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

    @RequestMapping("menus")
    public String show(){
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject_11=  new JSONObject();
        JSONObject jsonObject_12=  new JSONObject();
        jsonObject.put("id",101);
        jsonObject.put("authName","权限管理");
        jsonObject.put("path","rights");

        ArrayList<JSONObject> json1_child = new ArrayList<>();
        jsonObject_11.put("id",110);
        jsonObject_11.put("authName","权限分配");
        jsonObject_11.put("path","rights1");
        jsonObject_11.put("children",null);
        jsonObject_12.put("id",111);
        jsonObject_12.put("authName","权限查看");
        jsonObject_12.put("path","rights2");
        jsonObject_12.put("children",null);

        json1_child.add(jsonObject_11);
        json1_child.add(jsonObject_12);
        jsonObject.put("children",json1_child);
/*--------------------------------------------------------------------------------*/
        JSONObject jsonObject2 = new JSONObject();
        JSONObject jsonObject_2=  new JSONObject();
        jsonObject2.put("id",102);
        jsonObject2.put("authName","权限管理");
        jsonObject2.put("path","rights");
        jsonObject2.put("children",jsonObject_2);

        JSONObject jsonObject3 = new JSONObject();
        JSONObject jsonObject_3=  new JSONObject();
        jsonObject3.put("id",103);
        jsonObject3.put("authName","权限管理");
        jsonObject3.put("path","rights");
        jsonObject3.put("children",jsonObject_3);

        JSONObject jsonObject4 = new JSONObject();
        JSONObject jsonObject_4=  new JSONObject();
        jsonObject4.put("id",104);
        jsonObject4.put("authName","  权限管理");
        jsonObject4.put("path","rights");
        jsonObject4.put("children",jsonObject_4);

        JSONObject jsonObject5 = new JSONObject();
        JSONObject jsonObject_5=  new JSONObject();
        jsonObject5.put("id",105);
        jsonObject5.put("authName","  权限管理");
        jsonObject5.put("path","rights");
        jsonObject5.put("children",jsonObject_5);

        HashMap<String, Object> map = new HashMap<>();
        ArrayList<JSONObject> result = new ArrayList<>();
        result.add(jsonObject);
        result.add(jsonObject2);
        result.add(jsonObject3);
        result.add(jsonObject4);
        result.add(jsonObject5);
        map.put("data",result);
        JSONObject msg= new JSONObject();
        msg.put("msg","获取菜单列表成功");
        msg.put("status",200);
        map.put("meta",msg);
        return JSON.toJSONString(map);
    }
}
