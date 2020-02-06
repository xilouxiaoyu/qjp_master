package cn.itcast.gjp.service;


import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);

        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        Class<?> aClass = Class.forName(className);
        Object o = aClass.newInstance();

        Method method = aClass.getMethod(methodName,String.class);
        method.invoke(o,"Tom");
    }
}


