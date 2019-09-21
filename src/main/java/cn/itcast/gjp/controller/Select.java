package cn.itcast.gjp.controller;

import cn.itcast.gjp.domain.user;
import cn.itcast.gjp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author apple
 * @date 2019/9/3 下午12:34
 */
@Controller
@RequestMapping("select")
public class Select {
    @Autowired
    private UserService userService;
    @RequestMapping("id")
    @ResponseBody
    public user selectById(int id){
        return userService.selectOne(id);
    }
    @RequestMapping("nickName")
    @ResponseBody
    public List<user> selectByNickName(String nickName){
        return userService.selectUsers(nickName);
    }

}
