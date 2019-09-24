package cn.itcast.gjp.service;

import cn.itcast.gjp.test;
import org.springframework.stereotype.Service;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author apple
 * @date 2019/9/21 下午8:08
 */
@Service
public class RunTestService {
    public void run(){
        //method one

        /*TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] {test.class });
        testng.run();*/



        //method two

        /*XmlSuite suite = new XmlSuite();
        suite.setName("TmpSuite");

        XmlTest test = new XmlTest(suite);
        test.setName("TmpTest");
        List<XmlClass> classes = new ArrayList<XmlClass>();
        classes.add(new XmlClass("cn.itcast.gjp.test"));
        test.setXmlClasses(classes) ;
        List<XmlSuite> suites = new ArrayList<XmlSuite>();
        suites.add(suite);
        TestNG tng = new TestNG();
        tng.setXmlSuites(suites);
        tng.run();*/

        //method three
        TestNG testNG = new TestNG();
        ArrayList<String> list = new ArrayList<>();
        String path = this.getClass().getClassLoader().getResource("").getPath();/**/
        list.add(path + "TestNG.xml");
        testNG.setTestSuites(list);
        testNG.run();
    }
}
