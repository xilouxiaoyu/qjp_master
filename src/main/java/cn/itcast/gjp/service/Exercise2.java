package cn.itcast.gjp.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author apple
 * @date 2019/10/14 下午4:09
 */
public class Exercise2 {
    public static List<String> listStudy(){
        List<String> strings = new ArrayList<>();
        strings.add("abs");
        System.out.println(strings.get(0));
        strings.remove(0);
        strings.add("a");
        return strings;
    }

    public static void setStudy(){
        Set set = new HashSet();

        set.add("adjk");
        set.add("8923");
        set.remove("adjk");
        List<String> l1= new ArrayList<>();
        l1.add("172719");
        set.addAll(l1);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    public static void mapStudy(){
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name","wangyi");
        hashMap.put("name1","1323");
        System.out.println(hashMap.get("name1"));
        hashMap.containsKey("name");
        hashMap.remove("name1");

        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry:entries){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main(String[] args) {
        //listStudy();
        //setStudy();
        mapStudy();
    }
}


