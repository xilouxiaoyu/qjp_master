package cn.itcast.gjp.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidDataSourceConfiguration {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    /**
     * 配置一个druid的监控
     * 1.配置一个druid的后台管理Servlet
     * 2.配置一个druid的filter
     */
    //1. 使用StatViewServlet配置一个druid的后台管理Servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        //配置/druid/*请求
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //设置初始化参数值
        Map<String, String> initParam = new HashMap<>();
        //配置登录用户名
        initParam.put(StatViewServlet.PARAM_NAME_USERNAME, "root");
        //配置登录密码
        initParam.put(StatViewServlet.PARAM_NAME_PASSWORD, "123456");
        //如果不写，则默认所有ip都可以访问
        initParam.put(StatViewServlet.PARAM_NAME_ALLOW, "");
        //禁止访问的IP地址
        initParam.put(StatViewServlet.PARAM_NAME_DENY, "192.168.3.8");

        //设置初始化参数
        bean.setInitParameters(initParam);
        return bean;
    }

    //2.使用WebStatFilter配置一个druid的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        //添加过滤器
        bean.setFilter(new WebStatFilter());

        //设置初始化参数
        Map<String, String> initParam = new HashMap<>();
        //设置不拦截的请求
        initParam.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*");
        //设置初始化参数
        bean.setInitParameters(initParam);

        //设置拦截请求
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}

