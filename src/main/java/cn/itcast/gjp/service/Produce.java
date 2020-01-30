package cn.itcast.gjp.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor

public class Produce implements Runnable{
    public Object object = new Object();
    public ArrayList<Integer> produceList = new ArrayList<>();

    public Produce(Object object, ArrayList<Integer> produceList) {
        this.object = object;
        this.produceList = produceList;
    }

    public Produce(ArrayList<Integer> produceList) {
        this.produceList = produceList;
    }

    public void Produce() throws InterruptedException {
        synchronized (object){
            while (true) {
                while (produceList.size() < 3) {
                    produceList.add((int) Math.random());
                    object.notify();
                    System.out.println("在生产");
                }
                object.wait();//进入等待队列，等待被唤醒
            }
        }
    }

    @Override
    public void run() {
        try {
            this.Produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
