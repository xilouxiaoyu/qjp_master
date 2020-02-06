package cn.itcast.gjp.myStudy;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author apple
 * @date 2019/11/5 上午11:03
 */
public class streamStudy {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("","hjajja","hajj","jkjk");
        System.out.println("列表: " +strings);
        long count;
        count = strings.stream().filter(string->string.isEmpty()).count();
        System.out.println("空字符串数量为: " + count);

        List<String> string1=strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
        System.out.println("非空字符窗："+string1);

        Long string2 =strings.stream().filter(string->!string.isEmpty()).collect(Collectors.counting());
        System.out.println("******"+string2);

        List<String> string3 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        int count2 = (int) strings.parallelStream().filter(string -> !string.isEmpty()).count();
        System.out.println(count2);

        strings.forEach(stinga-> System.out.println(stinga));
        System.out.println("*********");
        string3.forEach(System.out::println);


        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        items.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

        items.forEach((k,v)->{
            System.out.println("Item : " + k + " Count : " + v);
            if("E".equals(k)){
                System.out.println("Hello E");
            }
        });
    }

}
