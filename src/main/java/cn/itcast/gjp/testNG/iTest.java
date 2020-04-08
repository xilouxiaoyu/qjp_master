package cn.itcast.gjp.testNG;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class iTest {

    public static int a;


    @Test
    public void testOne(){
        a = 2;
        System.out.println("testOne" + a);
        System.out.println("第一条测试用例"+Thread.currentThread().getName());
        Assert.assertEquals(1,1);

    }
    @Test
    private void testThree() {
        a = 1;
        System.out.println("testThree" + a);

        System.out.println("第三条测试用例" + Thread.currentThread().getName());

    }


    @Test
    public void test2() {
        ApplicationConfig application = new ApplicationConfig();
        application.setName("api-generic-consumer");
        //使用RegistryConfig, 动态配置注册中心地址
        RegistryConfig registry = new RegistryConfig();
        registry.setAddress("zookeeper://127.0.0.1:2181");
        application.setRegistry(registry);
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 弱类型接口名
        reference.setInterface("com.ymxdclass.user.service.UserService");
        // 声明为泛化接口
        reference.setGeneric(true);

        reference.setApplication(application);

        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();

        String name = (String) genericService.$invoke("sayHello", new String[]{String.class.getName()}, new Object[]{"who am i"});
        System.out.println(name);
    }
}
