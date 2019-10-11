package cn.itcast.gjp;


import cn.itcast.gjp.domain.testCase;
import cn.itcast.gjp.service.testCaseInOrderService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
    public Object[][] getdata(){
        Object[][] data1= testCaseInOrderService.data;
        return data1;
    }
}

