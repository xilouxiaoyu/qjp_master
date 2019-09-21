package cn.itcast.gjp.controller;

import cn.itcast.gjp.service.RunTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author apple
 * @date 2019/9/21 下午8:03
 */
@Controller
@RequestMapping("run")
public class RunTest
{
    @Autowired
    private RunTestService runTestService;
    @RequestMapping("test")
    public void runtest(){
        runTestService.run();

    }
}
