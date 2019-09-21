package cn.itcast.gjp.controller;

import cn.itcast.gjp.domain.user;
import cn.itcast.gjp.service.userInsertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author apple
 * @date 2019/9/3 下午2:42
 */
@Controller
@RequestMapping("insert")
public class Insert {
    @Autowired
    private userInsertService userInsertService;
    public void insert(user user){
        userInsertService.userInsert(user);
    }
}
