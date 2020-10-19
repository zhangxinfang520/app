package com.zxf.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.net.PortUnreachableException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * @author zxf
 * @date 2020/10/17-9:37
 */
public class DataSourceTest {
    @Test
    //测试druid数据源

    public void test2() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("zhang19980208");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    //测试c3p0
    public void test1() throws Exception {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc?serverTimezone=UTC");
        dataSource.setUser("root");
        dataSource.setPassword("zhang19980208");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    //已配置文件加载数据源
    public void test3() throws Exception {
        //加载配置资源
        ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
        String driver = bundle.getString("jdbc.driver");
        String url = bundle.getString("jdbc.url");
        String username = bundle.getString("jdbc.username");
        String password = bundle.getString("jdbc.password");
        //创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
    //spring 配置文件获取数据源
    @Test
    public void test4() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //DataSource datasource= (DataSource) app.getBean("dataSource");
        DataSource datasource= (DataSource) app.getBean(DataSource.class);
        Connection connection = datasource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
