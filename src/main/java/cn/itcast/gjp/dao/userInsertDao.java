package cn.itcast.gjp.dao;

import cn.itcast.gjp.domain.user;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface userInsertDao {
    void insertUser(user user);
}
