package com.zxf.proxy.cglib;

import com.zxf.proxy.jdk.TargetInterface;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zxf
 * @date 2020/10/25-10:02
 */
public class ProxyTest {
    public static void main(final String[] args) {
        //创建目标对象
        final Target target = new Target();

        //获得增强对象
        final Advice advice = new Advice();
        //返回值 就是动态生成的代理对象 基于cglib
        //1创建增强器
        Enhancer enhancer = new Enhancer();
        //2设置父类（目标）
        enhancer.setSuperclass(target.getClass());
        //3设置回调
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.before();
                Object invoke = method.invoke(target, args);
                advice.after();
                return invoke;

            }
        });
        //4设置代理对象
        Target o = (Target) enhancer.create();
        o.save();

    }
}
