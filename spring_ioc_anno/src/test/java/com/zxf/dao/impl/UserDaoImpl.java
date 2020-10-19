package com.zxf.dao.impl;

import com.zxf.dao.UserDao;
import org.springframework.stereotype.Component;

/**
 * @author zxf
 * @date 2020/10/19-9:08
 */
// <bean id="userDao" class="com.zxf.dao.impl.UserDaoImpl"></bean>
@Component("userDao")
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("sava running....");
    }
}
