package cn.itcast.gjp.myStudy;

import java.io.File;
import java.io.IOException;

public class treedir {

    /**
     *
     * @param file 文件
     * @param c 用于记录制表符
     */
    public static void getFileName(File file, String c){
        /**
         * 如果是文件夹,打印名称(带上制表符)
         */
        if(file.isDirectory()){
            System.out.println(c + file.getName());
        }
        /**
         * 获取所有子文件
         */
        File[] files = file.listFiles();
        for(File f : files){
            /**
             * 首先加一个制表符
             */
            String temp = c + "\t";
            if(f.isDirectory()){
                /**
                 * 如果是文件夹,则进行递归
                 */
                getFileName(f, temp);
            } else {
                /**
                 * 如果不是文件夹,则直接打印
                 */
                System.out.println(temp + f.getName());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        getFileName(new File("/Users/ximuxiao/Downloads/shellData/"), "");
    }
}

