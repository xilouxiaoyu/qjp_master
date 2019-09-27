package cn.itcast.gjp.service;

import java.util.concurrent.Callable;

/**
 * @author apple
 * @date 2019/9/27 下午3:33
 */

public class ChucjuCallable implements Callable {
        @Override
        public FutureCook.Chuju call() throws Exception {

            System.out.println("第一步下单");
            System.out.println("第一步等待送货");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new FutureCook.Chuju();
            }
    }

