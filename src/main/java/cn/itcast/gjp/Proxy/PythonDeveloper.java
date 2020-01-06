package cn.itcast.gjp.Proxy;

public class PythonDeveloper implements Developer {
    public String name;
    public PythonDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void code() {
        System.out.println(this.name+" is coding python");
    }

    @Override
    public void debug() {
        System.out.println(this.name+" is debug python");
    }

    public void play(){
        System.out.println(this.name+" is play name");
    }
}
