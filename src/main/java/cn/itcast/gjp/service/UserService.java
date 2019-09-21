package cn.itcast.gjp.service;

import cn.itcast.gjp.dao.userDao;
import cn.itcast.gjp.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author apple
 * @date 2019/9/1 下午5:32
 */
@Service
public class UserService {

    @Autowired
    private userDao dao;

    public user selectOne(int id) {
        return dao.selectById(id);
    }

    public List<user> selectUsers(String nickName){
        return dao.selectByNickName(nickName);
    }

}

