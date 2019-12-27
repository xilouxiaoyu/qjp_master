package cn.itcast.gjp.service;
import cn.itcast.gjp.domain.user;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author apple
 * @date 2019/11/4 下午2:40
 */
public class serializableStudy  {

    public void exer()throws Exception{

        //user user1= user.builder().mobile("18510217186").build();
        //user1 = user1.toBuilder().mobile("130000000").build();

        FileOutputStream f = new FileOutputStream(new File("foo.ser"));
        ObjectOutputStream os = new ObjectOutputStream(f);
        //os.writeObject(user1);
        os.close();
    }
}
