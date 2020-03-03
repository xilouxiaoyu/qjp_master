package cn.itcast.gjp.myStudy;

import java.io.*;

public class FileStudy {
    public static void main(String[] args) throws IOException {

        File file = new File("/Users/ximuxiao/Downloads/shellData/125.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        //file.mkdir();
        //file.delete();
        //FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileWriter fileWriter = new FileWriter(file,false);
        fileWriter.write("123");
        fileWriter.flush();
        fileWriter.close();

        FileInputStream fileInputStream = new FileInputStream(new File("/Users/ximuxiao/Downloads/shellData/125.txt"));
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[1024];
        while (bufferedInputStream.read(bytes, 0, bytes.length) != -1){
            String s = new String(bytes);
            System.out.println(s);
        }
    }
}
