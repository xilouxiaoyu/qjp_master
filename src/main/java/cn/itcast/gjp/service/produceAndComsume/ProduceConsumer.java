package cn.itcast.gjp.service.produceAndComsume;



import cn.itcast.gjp.service.produceAndComsume.Consume;
import cn.itcast.gjp.service.produceAndComsume.Produce;

import java.util.ArrayList;

public class ProduceConsumer {



    public static void main(String[] args) {
        Object o = new Object();
        ArrayList arrayList = new ArrayList();
        Produce produce = new Produce(o,arrayList);
        Consume consume = new Consume(o,arrayList);
        for (int i = 0; i < 1; i++) {
            Thread threadp = new Thread(produce);
            Thread threadc = new Thread(consume);
            threadp.start();
            threadc.start();


        }
    }
}



