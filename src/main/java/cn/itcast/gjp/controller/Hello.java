package cn.itcast.gjp.controller;


import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.json.Json;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@Slf4j
public class Hello {

    @RequestMapping("hello")
    @Transactional
    public String hello() {

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("hello", "world");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject.toString();
    }

    @RequestMapping("hello2")
    public String hello2(@RequestParam() String name,String passWord) {

        if (name.equals("hxq") && passWord.equals("123456")) {
            log.info("用户" + name);

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("hello", "world");
                jsonObject.put("hxq", "xq");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonObject.toString();
        }else {
            log.info("账号是" + name);
            return "账号或密码错误";
        }
    }
}
