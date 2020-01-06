package cn.itcast.gjp.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyInvoke implements InvocationHandler {
    public Object object;
    public ProxyInvoke(Object object) {
        this.object=object;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("开始");
        method.invoke(object,objects);
        System.out.println("结束");
        return null;
    }
}
