package cn.itcast.gjp.Proxy;

public class JavaDeveloper implements Developer {
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
}
