package cn.itcast.gjp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author apple
 * @date 2019/8/30 下午5:41
 */
@SpringBootApplication
@EnableAutoConfiguration
@ServletComponentScan
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
