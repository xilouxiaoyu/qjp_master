package cn.itcast.gjp.service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author apple
 * @date 2019/9/27 下午2:11
 */
public class FutureCook {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        Callable<Chuju> chujuOnline = new ChucjuCallable();

        /*Callable<Chuju> chujuOnline = new ChucjuCallable(){;
            @Override
            public Chuju call() throws Exception {
                System.out.println("第一步下单");
                System.out.println("第一步等待送货");
                Thread.sleep(10000);
                return new Chuju();
            }
        };*/


        FutureTask<Chuju> Task = new FutureTask<Chuju>(chujuOnline);
        new Thread(Task).start();
        Thread.sleep(2000);
        Shicai shicai = new Shicai();
        System.out.println("第二步：食材到位");
        Chuju chuju=Task.get();
        System.out.println("第三步：厨具到位，开始展现厨艺");
        cook(chuju,shicai);
        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    //  用厨具烹饪食材
    static void cook(Chuju chuju, Shicai shicai) {}

    // 厨具类
    static class Chuju {}

    // 食材类
    static class Shicai {}

}
