package cn.itcast.gjp.testNG;


import org.springframework.beans.factory.annotation.Autowired;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Transform implements IAnnotationTransformer {



    @Override
    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {

        testMethod.getDeclaredAnnotations();
        if(iTest.a == 0){
            annotation.setPriority(1);
            System.out.println(annotation.getPriority());
        }else {
            annotation.setPriority(0);
            System.out.println(annotation.getPriority());
        }


    }
}
