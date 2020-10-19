package com.zxf.service.impl;

import com.zxf.dao.UserDao;
import com.zxf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author zxf
 * @date 2020/10/19-9:10
 */
// <bean id="userService" class="com.zxf.service.impl.UserServiceImpl">
@Component("userService")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String value;

    //<property name="userDao" ref="userDao"></property>
//    @Autowired//按照数据类型从Spring容器进行匹配
//    @Qualifier("userDao")//是按照id值从容器中进行匹配的 但是此处@Qualifier结合 @Autowired一起使用
    @Resource(name = "userDao") //@Resource相当于@Qualifier结合+@Autowired
    private UserDao userDao;
    //注解可以把set方法删除
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    public void save() {
        System.out.println(value);
        userDao.save();
    }
    //初始化方法 注解
    @PostConstruct
    public void init(){
        System.out.println("Service 对象的初始化方法");
    }
    //销毁方法 注解
    @PreDestroy
    public void destory(){
        System.out.println("Service 对象的销毁方法");
    }
}
