package cn.itcast.gjp.controller;

import cn.itcast.gjp.service.AsyncStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.concurrent.Future;

/**
 * @author apple
 * @date 2019/9/29 下午3:55
 */
@Controller
@RequestMapping("async")
public class AsyncStudy {
    @Autowired
    public AsyncStudyService asyncStudyService;

    @RequestMapping("test")
    @ResponseBody
    public void AsyncTest() throws Exception{
        Future<String> future= asyncStudyService.asyncMethodWithReturnType();
        /*while (true) {
            if (future.isDone()) {  //判断是否执行完毕
                System.out.println("Result from asynchronous process - " + future.get());
                break;
            }
            System.out.println("Continue doing something else. ");
            Thread.sleep(2000);
        }*/
        while (!future.isDone()) {
            System.out.println("Continue doing something else. ");
            Thread.sleep(2000);
        }
        System.out.println("Result from asynchronous process - " + future.get());
        for(;;) {

        }
    }

}
