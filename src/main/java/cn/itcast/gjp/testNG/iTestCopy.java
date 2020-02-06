package cn.itcast.gjp.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class iTestCopy {

    @Test(enabled=true, threadPoolSize=5, invocationCount=10)
    public void testTwo(){
        System.out.println("第二条测试用例"+Thread.currentThread().getName());
        //Assert.assertEquals(1,1);
    }
}
