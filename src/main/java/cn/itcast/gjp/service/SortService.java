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

    public static void readFile(File file1,File file2) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(file1);
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
            for(int j=i+1;j<strings.size();j++){
                if((strings.get(i)).equals((strings.get(j)))){
                    strings.remove(j);
                    j--;
                }
            }
        }
        for(String s:strings){
            System.out.println(s);
        }
        FileOutputStream fileWrite = new FileOutputStream("file2");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileWrite);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        for(String s:strings){
            bufferedWriter.write(s);
            bufferedWriter.flush();
        }

        fileWrite.close();

    }
    public static void main(String[] args) throws IOException {
        /*int a[]={1,10,3};
        sort(a);
        for(Object obj:a){
        System.out.println(obj);*/
        readFile(new File("/Users/apple/IdeaProjects/a/123"),new File("/Users/apple/IdeaProjects/a/234"));
        }
    }


