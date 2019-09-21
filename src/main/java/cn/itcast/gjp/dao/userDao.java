package cn.itcast.gjp.dao;



import cn.itcast.gjp.domain.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author apple
 * @date 2019/8/27 下午6:40
 */
@Mapper
public interface userDao {

    /**
     * 查询一个用户
     */
     user selectById(@Param("id") int ids);
     List<user> selectByNickName(@Param("nickName") String nickName);
}