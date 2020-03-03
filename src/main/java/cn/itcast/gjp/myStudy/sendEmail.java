package cn.itcast.gjp.myStudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class sendEmail {

    @Autowired
    private JavaMailSender javaMailSender;

    //@Value("$smtp.qq.com")
    private String serverMail = "smtp.qq.com";

    //发送邮件的模板引擎
    @Autowired
    private FreeMarkerConfigurer configurer;

    public void sendMail(String toUser, String subject, String text) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(serverMail);
        helper.setTo(toUser);
        helper.setSubject(subject);
        helper.setText(text, true);

        javaMailSender.send(message);
    }

    public static void sendEmail() throws Exception{

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost("smtp.qq.com");
        sender.setUsername("821014243@qq.com");
        sender.setPassword("seermuqypgylbegi");


        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.auth", true);
        javaMailProperties.put("mail.smtp.starttls.enable", true);
        javaMailProperties.put("mail.smtp.timeout", 5000);
        sender.setJavaMailProperties(javaMailProperties);


        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo("821014243@qq.com");
        helper.setText("Thank you for ordering!");

        sender.send(message);
    }

    public static void main(String[] args) throws Exception{

        sendEmail();

    }


}
