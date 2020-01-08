package cn.itcast.gjp.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class  Consume implements Runnable{
    public Object object = new Object();
    public ArrayList<Integer> produceList =new ArrayList<>();

    public Consume(ArrayList<Integer> produceList) {
        this.produceList = produceList;
    }

    public Consume(Object object, ArrayList<Integer> produceList) {
        this.object = object;
        this.produceList = produceList;
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
