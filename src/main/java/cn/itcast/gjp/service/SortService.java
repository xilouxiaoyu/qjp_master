package cn.itcast.gjp.service;

import java.io.*;
import java.util.ArrayList;

/**
 * @author apple
 * @date 2019/9/24 上午11:27
 */
public class SortService {
    public static void sort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                if (a[i] > a[j]){
                   int m=a[i];
                   a[i]=a[j];
                   a[j]=m;
                }
            }
        }

    }

    public static void readFile(File file) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String tempchar;
        ArrayList<String> strings = new ArrayList<String>();
        while ((tempchar = bufferedReader.readLine()) != null){
            //String s=bufferedReader.readLine();
            System.out.println(tempchar);
            strings.add(tempchar);

        }
        System.out.println("==========");
        fileInputStream.close();
        for(int i=0;i<strings.size();i++){
            for(int j=i+1;i<strings.size();i++){
                if((strings.get(i))==((strings.get(j)))){
                    strings.remove(j);
                }
            }
        }
        for(String s:strings){
            System.out.println(s);
        }

    }
    public static void main(String[] args) throws IOException {
        /*int a[]={1,10,3};
        sort(a);
        for(Object obj:a){
        System.out.println(obj);*/
        readFile(new File("/Users/apple/IdeaProjects/a/123"));
        }
    }

