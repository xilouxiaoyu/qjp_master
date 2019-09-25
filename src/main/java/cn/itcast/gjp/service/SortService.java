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
        //FileInputStream fileInputStream = new FileInputStream(file1);
        //InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        FileReader fileReader = new FileReader(file1);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String tempchar;
        ArrayList<String> strings = new ArrayList<String>();
        while ((tempchar = bufferedReader.readLine()) != null){
            //String s=bufferedReader.readLine();
            System.out.println(tempchar);
            strings.add(tempchar);

        }
        System.out.println("==========");
        bufferedReader.close();
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

        FileWriter fileWriter = new FileWriter(file2);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for(String s:strings){
        bufferedWriter.write(s+"    ");
            bufferedWriter.flush();
        }
        bufferedWriter.close();

    }

    public static void sortString(String[] strings){
        for(int i=0;i<strings.length;i++){
            for(int j=i+1;j<strings.length;j++){
                if ((strings[i]).compareTo(strings[j])>0){
                    String m=strings[i];
                    strings[i]=strings[j];
                    strings[j]=m;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        //数字排序
        /*int a[]={1,10,3};
        sort(a);
        for(Object obj:a){
        System.out.println(obj);*/

        //将一个文件中的字符串去重写入另一个文件中
        //readFile(new File("/Users/apple/IdeaProjects/a/123"),new File("/Users/apple/IdeaProjects/a/234"));

        //数组中的字符串排序
        String[] strings={"ABC","abn","mkaj","hjand","ghaja"};
        sortString(strings);
        for(Object obj:strings){
            System.out.println(obj);
        }
    }
}


