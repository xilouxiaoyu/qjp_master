package cn.itcast.gjp;


import cn.itcast.gjp.domain.testCase;
import cn.itcast.gjp.service.testCaseInOrderService;
import org.springframework.context.annotation.DependsOn;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author apple
 * @date 2019/9/20 下午3:56
 */

public class test {


    @Test(dataProvider = "test")
    public void test1(testCase testCase){
        this.runTestCase(testCase);
    }

    private void runTestCase(testCase testCase) {
        System.out.println(testCase.toString());
    }

    @DataProvider(name ="test")
    @BeforeMethod(dependsOnMethods = "test1")
    @BeforeTest()
    public Object[][] getdata(){
        Object[][] data1= testCaseInOrderService.data;
        return data1;
    }

    public static void main(String[] args) {
        test test = new test();
        Class<? extends cn.itcast.gjp.test> aClass = test.getClass();
        try {
            /*Method[] methods = aClass.getMethods();
            for(Method method:methods){
                System.out.println(method);
            }*/
            //System.out.println(aClass.getMethod("test1"));
            Annotation[] getdata = aClass.getMethod("test1",testCase.class).getAnnotations();
            System.out.println(getdata.length);
            for(Annotation an:getdata){
                System.out.println(an);
                String s = an.toString();
                if (s.contains("DataProvider")){
                    System.out.println("该注解是DataProvider");
                }else {
                    System.out.println("该注解不是DataProvider");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

