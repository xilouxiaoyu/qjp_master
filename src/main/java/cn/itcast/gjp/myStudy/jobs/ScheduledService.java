package cn.itcast.gjp.myStudy.jobs;


import org.springframework.stereotype.Component;

@Component
public class ScheduledService {
   /* @Scheduled(cron = "0/5 * * * * *")
    public void scheduled() {
        System.out.println("=====>>>>>使用cron");
    }

    @Scheduled(fixedRate = 5000)
    public void scheduled1() {
        System.out.println("=====>>>>>fixedRate");
    }

    @Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        System.out.println("=====>>>>>fixedDelay");
    }*/

    public static void main(String[] args) {
        String s = new String("a");
        String s1 = new String("a");
        lock(s);
        lock(s);

    }

    static void lock(String string) {
        System.out.println(string);
        synchronized (string) {

        }
    }
}


