package cn.itcast.gjp.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

import java.util.concurrent.Future;

/**
 * @author apple
 * @date 2019/9/29 下午2:34
 */
public class AsyncStudy {

    @Async
    public void asyncMethodWithVoidReturnType(){
        System.out.println("Execute method asynchronously."+Thread.currentThread().getName());
    }
    @Async
    public Future<String> asyncMethodWithReturnType(){
        System.out.println("Execute method asynchronously."+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<String>("hello world !!!!");
        } catch (InterruptedException e) {
                   //
                }
        return null;
    }
}
