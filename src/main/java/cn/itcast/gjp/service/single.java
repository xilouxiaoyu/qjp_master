package cn.itcast.gjp.service;

/**
 * @author apple
 * @date 2019/10/14 下午3:51
 */
public class single {

    private static single instance;

    private single(){

    }
    public static single getInstance(){
        if (instance == null) {
            instance = new single();
        }
        return instance;

    }

    public void showMessage(){
        System.out.println("Hello World!");
    }
}
