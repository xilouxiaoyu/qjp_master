package cn.itcast.gjp.myStudy.threadStudy;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lockStudy {
    public Lock rLock = new ReentrantLock();

    public void lockTest(Thread thread) throws InterruptedException {

        if(rLock.tryLock(3000, TimeUnit.MILLISECONDS)){
            try{
                System.out.println(thread.getName()+"获取当前锁");
                thread.sleep(2000);
            }catch (Exception e){
                System.out.println(thread.getName()+"发生了异常释放锁");
            }finally {
                System.out.println(thread.getName()+"执行完毕释放锁");
                rLock.unlock();
            }
        }else {
            System.out.println(thread.getName()+"当前锁被别人占用,等待3s后仍无法获取,放弃");
        }
    }

    public static void main(String[] args) {
        lockStudy lockStudy = new lockStudy();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockStudy.lockTest(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lockStudy.lockTest(Thread.currentThread());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
