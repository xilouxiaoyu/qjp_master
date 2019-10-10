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
    public List<testCase> allInOrder(){
        List<testCase> result=new ArrayList<>();
        boolean depend;
        List<String> ScenesNames =testcaseDao.selectBydepend();
        for(String scenname:ScenesNames){
                List<testCase> tCases=testcaseDao.selectByScenesName(scenname);
                for(testCase tCase:tCases) {
                    result.add(tCase);
                }
            }

            /*List<testCase> tCases=testcaseDao.selectByScenesName(tcase.getScenesName());
            result.add(tCases.toString());*/

        return result;
    }
}
