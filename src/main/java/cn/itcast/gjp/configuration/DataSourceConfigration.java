package cn.itcast.gjp.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.alibaba.druid.pool.DruidDataSource;;

import javax.sql.DataSource;

/**
 * @author apple
 * @date 2019/9/1 下午5:51
 */
@Configuration
@MapperScan(basePackages = "cn.itcast.gjp.dao")
public class DataSourceConfigration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.teststage")
    @Primary
    public DataSource setDataSource() {
        return new DruidDataSource();
    }

    @Bean
    @Primary
    public DataSourceTransactionManager setTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    @Primary
    public SqlSessionFactory setSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        bean.setConfiguration(configuration);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:Mapper/*.xml"));
        return bean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate setSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
