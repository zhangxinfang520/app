package com.zxf.web;

import com.zxf.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zxf
 * @date 2020/10/19-9:16
 */
public class UserController {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) app.getBean("userService");
        userService.save();
        app.close();
    }
}
