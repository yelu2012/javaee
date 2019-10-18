package com.uws.yl.proxy.cglibproxy.clazz;

import com.uws.yl.proxy.jdkproxy.clazz.MyInterceptor;
import com.uws.yl.proxy.jdkproxy.inter.Interceptor;

/**
 * @author yelu
 * @ClassName Client
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/14 0014下午 3:34
 */
public class Client {
    public static void main(String[] args) {
        Interceptor interceptor1 = new MyInterceptor("1");
        HelloWorldImpl helloWorld1 =  CglibProxy.getProxy(HelloWorldImpl.class, interceptor1);
        helloWorld1.sayHello("hello");
    }
}