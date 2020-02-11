package cn.itcast.gjp.service.produceAndComsume;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
public class  Consume implements Runnable{
    public Object object = new Object();
    public ArrayList<Integer> produceList =new ArrayList<>();

    public Consume(Object o, ArrayList arrayList) {
    }


    public void Consum() throws InterruptedException {
        synchronized (object){
            while (true) {
                while (produceList.size() > 0) {
                    produceList.remove(0);
                    object.notify();
                    System.out.println("在消费");
                }
                object.wait();//进入等待队列，等待被唤醒
            }
        }
    }

    @Override
    public void run() {
        try {
            this.Consum();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
