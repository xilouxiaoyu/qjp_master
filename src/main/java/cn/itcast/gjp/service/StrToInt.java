package cn.itcast.gjp.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrToInt {

    public static void strToInt(String s){
        int value = 0;
        try {
            Integer integer = Integer.valueOf("127");
            Integer integer1 = Integer.valueOf("127");
            Integer integer2 = Integer.valueOf("128");
            Integer integer3 = Integer.valueOf("128");
            System.out.println(integer==integer1);
            System.out.println(integer2==integer3);

            String s1 = String.valueOf('a');
            System.out.println(s1);

            int i = Integer.parseInt(s);
            System.out.println(value);
            System.out.println(i);
        }catch (Exception e){
            System.out.println(e);
        }
    }


    public static int selectCountInfile(String filename,String str) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

        StringBuilder readLine=new StringBuilder();
        String line;
        /**
         * BufferedReader的readLine()方法用来读一行文字， 一行被视为由换行符（'\ n'），回车符（'\ r'）中的任何一个或随后的换行符终止
         */
        while((line=br.readLine())!=null) {
            readLine.append(line);//把读到的一行文字追加到StringBuilder字符串中
        }
        int index;
        int count = 0;
        /**
         * StringBuilder的indexOf(string类型)方法：返回指定子字符串第一次出现的字符串内的索引
         * 如果字符串参数作为该对象中的子字符串发生，则返回第一个这样的子字符串的第一个字符的索引; 如果它不作为子串发生，则返回-1
         */
        while ((index=readLine.indexOf(str))!=-1) {
            /**
             * 删除此序列的子字符串中的字符
             */
            //readLine.delete(index, index+str.length());
            String s = readLine.substring(index+str.length());
            readLine =new StringBuilder(s);
            count++;
        }
        return count;
    }

        public static void main(String[] args){
            try {
                int count = selectCountInfile("/Users/ximuxiao/Downloads/shellData/125.txt", "abc");
                System.out.println(count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
