package cn.itcast.gjp.Proxy;

import java.lang.reflect.Proxy;

public class testProxy {
    public static void main(String[] args) throws NoSuchMethodException {
        JavaDeveloper tom = new JavaDeveloper("Tom");
        ProxyInvoke proxyInvoke = new ProxyInvoke(tom);
        Developer tomProxy = (Developer)Proxy.newProxyInstance(tom.getClass().getClassLoader(), tom.getClass().getInterfaces(), proxyInvoke);
        tomProxy.code();
        tomProxy.debug();
        Human tom1Proxy=(Human)Proxy.newProxyInstance(tom.getClass().getClassLoader(),tom.getClass().getInterfaces(),proxyInvoke);
        int salar = tom1Proxy.salar();
        tom1Proxy.work();
        System.out.println("****************");

        PythonDeveloper jack = new PythonDeveloper("jack");
        ProxyInvoke jackProxyInvoke = new ProxyInvoke(jack);
        Developer jackProxy=(Developer)Proxy.newProxyInstance(jack.getClass().getClassLoader(),jack.getClass().getInterfaces(),jackProxyInvoke);
        jackProxy.debug();
        jackProxy.code();
    }
}
