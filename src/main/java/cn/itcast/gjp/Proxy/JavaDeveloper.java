package cn.itcast.gjp.Proxy;

public class JavaDeveloper implements Developer,Human {
    public String name;

    public JavaDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void code(){
        System.out.println(this.name+"is coding now");
    }

    @Override
    public void debug() {
        System.out.println(this.name+"is debuging now");
    }

    @Override
    public String work() {
        System.out.println(this.name+" 在加班");

        return this.name+"在加班";
    }

    @Override
    public int salar() {
        int mySalar =100;
        System.out.println(this.name +"的工资是100");
        return mySalar;
    }
}
