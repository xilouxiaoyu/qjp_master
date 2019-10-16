package cn.itcast.gjp.service;

/**
 * @author apple
 * @date 2019/10/14 下午3:51
 */
public class single {

    /**
     * 懒汉模式
     */

    /*private static single instance;

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
    }*/
    /**
     * 双加锁延迟
     */

   /* private static single instance;

    private single(){

    }
    public static single getInstance() {
        if (instance == null) synchronized (single.class) {
            if (instance == null) {
                instance = new single();
            }
        }
        return instance;
    }

    public void showMessage(){
        System.out.println("Hello World!");
    }*/

    /**
     * 内部类实现
     */

    private single() {
    }

    public static single getInstance() {
        return InnerClass.ins;
    }

    private static class InnerClass {
        private static final single ins = new single();
    }

}
