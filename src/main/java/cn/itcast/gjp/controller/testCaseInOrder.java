package cn.itcast.gjp.controller;

import cn.itcast.gjp.domain.testCase;
import cn.itcast.gjp.service.testCaseInOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author apple
 * @date 2019/10/8 上午11:27
 */
@Controller
@RequestMapping("order")
@Slf4j
public class testCaseInOrder {
    @Autowired
    public testCaseInOrderService testCaseInOrderService;
    @RequestMapping("testRun")
    @ResponseBody
    public String testOrder(int id){
        return testCaseInOrderService.oneInOrder(id);
    }

    @RequestMapping("testRunAll")
    @ResponseBody
    public List<testCase> testOrder(){
        return testCaseInOrderService.allInOrder();
    }

}
