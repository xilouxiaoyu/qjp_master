package cn.itcast.gjp.threadStudy;

import java.util.concurrent.CountDownLatch;

public class countDownStudy {


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(10);


        for(int i =0; i<10 ;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("******");
                    c.countDown();
                }
            }
            );
            thread.start();
        }
        c.await();
        System.out.println("我去吃饭了");
    }
}
