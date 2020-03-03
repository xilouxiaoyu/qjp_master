package cn.itcast.gjp.myStudy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.testng.annotations.Test;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Slf4j

public class sendEmail2 {


    public static void simpleMailSend(String email , String subject, String msg)throws Exception {
        //创建邮件发送服务器
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
//      mailSender.setPort(465);
        mailSender.setUsername("821014243@qq.com");
        mailSender.setPassword("yyejogviiuaabdig");
        //加认证机制
       /* Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.smtp.starttls.enable", true);
        javaMailProperties.put("mail.smtp.timeout", 5000);
        mailSender.setJavaMailProperties(javaMailProperties);*/
        //创建邮件内容
        /*SimpleMailMessage message=new SimpleMailMessage();
        message.setFrom("821014243@qq.com");
        message.setTo(emailList.toArray(new String[emailList.size()]));
        message.setSubject(subject);
        message.setText(msg);

        //发送邮件
        mailSender.send(message);*/


        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        //发送附件
        //helper.addAttachment("test",new File("/Users/ximuxiao/Downloads/122.txt"));
        helper.setFrom("821014243@qq.com");
        helper.setTo(email);
        helper.setSubject("test");
        helper.setText("http://baidu.com");

        mailSender.send(message);



    }

    public static void main(String[] args) throws Exception {
        log.info("发送邮件开始");
       /* ArrayList<String> emailList = new ArrayList<>();
        //String[] emails = {"821014243@qq.com","xiaoqing4823@163.com"};
        emailList.add("xiaoqing4823@163.com");*/
        //emailList.add("xiaoqing4823@163.com");
        String email = "821014243@qq.com";

        simpleMailSend(email,"测试！！！","发送成功！！！");
        log.info("发送邮件结束");
    }
}
