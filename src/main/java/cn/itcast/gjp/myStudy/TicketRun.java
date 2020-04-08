package cn.itcast.gjp.myStudy;

public class TicketRun{

    public static void main(String[] args) {
        TicketRun1 ticketRun1 = new TicketRun1();
        Thread thread = new Thread(ticketRun1);
        Thread thread1 = new Thread(ticketRun1);
        thread.run();
        thread1.run();
    }
}

class TicketRun1 implements Runnable {

    private static int ticket = 100;

    @Override
    public void run() {

        while (true){
            synchronized (this){
                if(ticket <= 0){
                    break;
                }
                try {
                    Thread.sleep(10);	//可能造成：线程1睡,线程2睡,线程3睡,线程4睡
                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "...这是第" + ticket-- + "号票");
            }
        }

    }
}
