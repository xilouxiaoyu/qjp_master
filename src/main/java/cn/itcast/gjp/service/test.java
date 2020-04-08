package cn.itcast.gjp.service;

import java.io.*;

public class test {

    public static int function(int n){
        if(n ==1 || n==2){
            return 1;
        }
        else return function(n-1) + function(n-2);
    }

    public static void main(String[] args) throws Exception{
        System.out.println(count("/Users/ximuxiao/Downloads/shellData/125.txt"));
    }

    public static int count (String file) throws Exception{
        FileReader fileReader = new FileReader(new File(file));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int count =0;
        String temp;
        boolean flag = true;
        while ((temp=bufferedReader.readLine())!=null){
            if(temp.contains("/*")){
                flag = false;
            }
            if(!temp.substring(0,2).equals("/*") && flag){
                count++;
            }
            if(temp.contains("*/")){
                flag = true;
            }
        }
        return count;
    }
}
