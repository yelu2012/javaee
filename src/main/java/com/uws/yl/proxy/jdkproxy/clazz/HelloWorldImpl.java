package com.uws.yl.proxy.jdkproxy.clazz;

import com.uws.yl.proxy.jdkproxy.inter.HelloWorld;

/**
 * @author yelu
 * @ClassName HelloWorldImpl
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/14 0014下午 1:53
 */
public class HelloWorldImpl implements HelloWorld {
    @Override
    public void sayHelloWorld() {
        System.out.println("实际对象say hello world");
    }
}
