package cn.itcast.gjp.testNG;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MethodInterceptors implements IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> result = new ArrayList<IMethodInstance>();
        for(IMethodInstance imethod : methods){

            HashSet<String> groups = new HashSet<String>();
            if(imethod.getMethod().isTest()){

            }
        }

        
        
        return result;

    }
}
