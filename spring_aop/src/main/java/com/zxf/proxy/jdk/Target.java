package com.zxf.proxy.jdk;

/**
 * @author zxf
 * @date 2020/10/25-9:59
 */
public class Target implements TargetInterface {
    public void save() {
        System.out.println("save running");
    }
}
