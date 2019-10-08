package cn.itcast.gjp.dao;

import cn.itcast.gjp.domain.testCase;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author apple
 * @date 2019/10/8 上午10:56
 */
@Mapper
public interface testCaseDao {

    /**
     * 依据depend查询
     */
    List<testCase> selectBydepend();//@Param("depend") boolean depend);
    /**
     * 依据id查询
     */
    testCase selectById(@Param("id") int id);

    List<testCase> selectAll();


}
