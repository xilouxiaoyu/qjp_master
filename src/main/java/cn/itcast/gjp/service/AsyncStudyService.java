package cn.itcast.gjp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author apple
 * @date 2019/9/29 下午2:34
 */
@Service
public class AsyncStudyService {
    @Autowired
    public static AsyncStudyService asyncStudyService;

    @Async
    public void asyncMethodWithVoidReturnType(){
        System.out.println("Execute method asynchronously."+Thread.currentThread().getName());
    }

    @Async("taskExecutor")
    public Future<String> asyncMethodWithReturnType(){
        System.out.println("Execute method asynchronously."+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
            return new AsyncResult<String>("hello world !!!!");
        } catch (InterruptedException e) {
                   //
                }
        return null;
    }
}


