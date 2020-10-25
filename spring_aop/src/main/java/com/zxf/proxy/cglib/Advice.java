package com.zxf.proxy.cglib;

/**
 * @author zxf
 * @date 2020/10/25-10:00
 */
public class Advice {

    public void before(){
        System.out.println("前置增强");
    }
    public void after(){
        System.out.println("后置增强");
    }
}
