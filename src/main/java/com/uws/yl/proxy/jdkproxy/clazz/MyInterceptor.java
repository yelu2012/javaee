package com.uws.yl.proxy.jdkproxy.clazz;

import com.uws.yl.proxy.jdkproxy.inter.Interceptor;

import java.lang.reflect.Method;

/**
 * @author yelu
 * @ClassName MyInterceptor
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/14 0014下午 2:39
 */
public class MyInterceptor implements Interceptor {

    private String name;
    public MyInterceptor(String name){
        this.name = name;
    }
    @Override
    public void before(Object proxy, Method method, Object[] args) {
        System.out.println("before......."+name);
    }

    @Override
    public void after(Object proxy, Method method, Object[] args) {
        System.out.println("after......."+name);
    }

    @Override
    public void around(Object proxy, Method method, Object[] args) {

    }
}
