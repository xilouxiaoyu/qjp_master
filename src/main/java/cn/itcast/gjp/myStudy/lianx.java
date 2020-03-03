package cn.itcast.gjp.myStudy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class lianx {
    public static void main(String[] args) {
        byte[] aByte =new byte[10];
        aByte[1] = 97;
        aByte[2] = 98;
        String s1 = new String(aByte);
        System.out.println(s1);
        byte[] bs1 = {97,98,100};
        String s = new String(bs1);
        System.out.println(s);


        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        System.out.println(format);
    }
}
