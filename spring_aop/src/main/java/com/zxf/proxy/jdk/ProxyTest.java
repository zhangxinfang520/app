package com.zxf.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zxf
 * @date 2020/10/25-10:02
 */
public class ProxyTest {
    public static void main(String[] args) {
        //创建目标对象
        final Target target = new Target();

        //获得增强对象
        final Advice advice = new Advice();

        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),//目标对象加载器
                target.getClass().getInterfaces(), //目标对象相同的接口字节码对象数组
                new InvocationHandler() {
                    //调用代理对象的任何方法 实质都执行invoke方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before();//前置增强
                        method.invoke(target, args);//执行目标方法;
                        advice.after();//后置增强
                        return null;
                    }
                }
        );
        proxy.save();
    }
}
