package cn.itcast.gjp.service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author apple
 * @date 2019/10/14 下午4:09
 */
public class Exercise2 {
    public static List<String> listStudy(){
        System.out.println("===list===");
        List<String> strings = new ArrayList<>();
        strings.add("abs");
        strings.remove(0);
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        for (String s:strings){
            System.out.println(s);
        }
        return strings;
    }

    public static void setStudy(){
        System.out.println("===set===");
        Set set = new HashSet();
        set.add("adjk");
        set.add("8923");
        set.add("8923");
        set.add("hakja");
        set.add("79273heh");
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
        System.out.println("===map===");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name","wangyi");
        hashMap.put("name1","lisi");
        hashMap.put("name3","qqqq");
        hashMap.put("name4","aaaa");
        hashMap.put("name5","zzzz");
        hashMap.put("name6","zzzz");
        System.out.println(hashMap.get("name1"));
        hashMap.containsKey("name");
        hashMap.remove("name1");
        System.out.println(hashMap);
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Map.Entry<String, String> entry:entries){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main(String[] args) {
        listStudy();
        setStudy();
        mapStudy();
    }
}

