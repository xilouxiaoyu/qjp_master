package cn.itcast.gjp.service;


import java.util.concurrent.*;

public class scheduleStudy {
    public static void main(String[] args) {
        final long begin = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            final long time = begin;
            executorService.submit(new Runnable(){
                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "   i=" + temp + "   time=" + (System.currentTimeMillis() - time));
                }
            },500);
        }
        executorService.shutdown();
    }
}