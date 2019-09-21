package cn.itcast.gjp.service;

import cn.itcast.gjp.dao.userInsertDao;
import cn.itcast.gjp.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @author apple
 * @date 2019/9/1 下午9:36
 */
@Service
public class userInsertService {
    @Autowired
    private userInsertDao userInsertDao;
    public void userInsert(user user){
        userInsertDao.insertUser(user);
    }
}
