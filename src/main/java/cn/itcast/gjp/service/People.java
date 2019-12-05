package cn.itcast.gjp.service;

/**
 * @author apple
 * @date 2019/11/28 下午5:25
 */
public abstract class People {
    public String name;
    public int age;
    public String sex;
    public static void run(){
        System.out.println("在跑步");

    }
    public abstract void eat();
}
