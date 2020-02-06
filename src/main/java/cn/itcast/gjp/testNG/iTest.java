package cn.itcast.gjp.testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class iTest {

    @Test(dependsOnMethods = "tesThree")
    public void testOne(){
        System.out.println("第一条测试用例"+Thread.currentThread().getName());
        Assert.assertEquals(1,1);
    }
    @Test
    private void tesThree() {
        System.out.println("第三条测试用例" + Thread.currentThread().getName());

    }
}
