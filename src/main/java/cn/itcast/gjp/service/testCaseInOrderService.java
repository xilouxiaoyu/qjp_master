package cn.itcast.gjp.service;

import cn.itcast.gjp.dao.testCaseDao;
import cn.itcast.gjp.domain.testCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author apple
 * @date 2019/10/8 上午11:35
 */
@Service
public class testCaseInOrderService {

    public static Object[][] data;

    @Autowired
    public testCaseDao testcaseDao;
    public String oneInOrder(int id){
        String result=null;
        boolean depend=false;
        testCase testCase=testcaseDao.selectById(id);
            /*if (testCase.isDepend()){
                List<testCase> testCases=testcaseDao.selectBydepend();
                result=testCases.toString();
            }
            else {
                result=testCase.toString();
            }*/
        return result;
    }
    public ArrayList<testCase> allInOrder(){

        ArrayList<testCase> result=new ArrayList<>();
        boolean depend;
        List<String> ScenesNames =testcaseDao.selectBydepend();
        for(String scenname:ScenesNames) {
            List<testCase> tCases = testcaseDao.selectByScenesName(scenname);
            for (testCase tCase : tCases) {
                result.add(tCase);
            }
        }
        int m=4;
        data = new Object[m][1];
        for(int i=0;i<m;i++){
            data[i][0] = result.get(i);
        }
        return result;

    }

}

