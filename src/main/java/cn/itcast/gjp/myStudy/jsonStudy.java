package cn.itcast.gjp.myStudy;

import cn.itcast.gjp.domain.user;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class jsonStudy {
    public static void main(String[] args) {
        JSONObject jo = new JSONObject();
        ArrayList<String> adds = new ArrayList<>();
        adds.add("山西");
        adds.add("陕西");

        user user = new user(1,"lisi","13210101212","lisi");


        jo.put("name", "zhangsan");
        jo.put("mobile", "13211112222");
        jo.put("age", 12);
        jo.put("add", adds);
        jo.put("user",user);



        System.out.println(jo.toString());
//      JSONArray objects2 = JSONObject.parseArray(jo.toString());


        for (Map.Entry<String, Object> entry : jo.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }


        String s = JSON.toJSONString(jo);
        System.out.println(s);
        String name = jo.getString("name");
        System.out.println(name);
        JSONArray addArray = jo.getJSONArray("add");
        System.out.println(addArray.toString());
        System.out.println(jo.getInteger("age"));

        JSONObject user2 = jo.getJSONObject("user");
        Integer id = user2.getInteger("id");
        System.out.println(id);
        System.out.println("88888");


        String aba = "[12]";
        JSONArray objects = JSONArray.parseArray(aba);
        System.out.println(objects);

        JSONArray objects1 = JSONObject.parseArray(aba);
        System.out.println(objects1);
    }
}

