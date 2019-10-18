package com.uws.yl.proxy.jdkproxy.clazz;

import com.uws.yl.proxy.jdkproxy.inter.HelloWorld;
import com.uws.yl.proxy.jdkproxy.inter.Interceptor;

/**
 * @author yelu
 * @ClassName Client
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/14 0014下午 2:40
 */
public class Client {

    public static void main(String[] args) {
        Interceptor interceptor1 = new MyInterceptor("1");
        Interceptor interceptor2 = new MyInterceptor("2");
        Interceptor interceptor3 = new MyInterceptor("3");
        HelloWorld helloWorld1 = (HelloWorld)JdkProxy.getProxyObject(new HelloWorldImpl(),interceptor1);
        HelloWorld helloWorld2 = (HelloWorld)JdkProxy.getProxyObject(helloWorld1,interceptor2);
        HelloWorld helloWorld3 =  (HelloWorld)JdkProxy.getProxyObject(helloWorld2,interceptor3);
        helloWorld3.sayHelloWorld();
    }
}
