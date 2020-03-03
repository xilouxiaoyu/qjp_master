package cn.itcast.gjp.myStudy;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateStudy {
    public static void main(String[] args) throws Exception{
        Date date = new Date();
        Date date1 = new Date(18829839);
        System.out.println(date);

        DateFormat dateFormat = new SimpleDateFormat();
        dateFormat.format(date);
        System.out.println(date);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = df.format(date);
        System.out.println(format);

        Date parse = df.parse(format);
        System.out.println(parse);


        Calendar instance = Calendar.getInstance();
        Date time1 = instance.getTime();
        String format1 = df.format(time1);
        System.out.println(format1);

    }
}
