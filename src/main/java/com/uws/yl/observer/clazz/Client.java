package com.uws.yl.observer.clazz;

/**
 * @author yelu
 * @ClassName Client
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/14 0014下午 3:56
 */
public class Client {
    public static void main(String[] args) {
        Publish publish = new Publish();
        Subscribe1 subscribe1 = new Subscribe1();
        Subscribe2 subscribe2 = new Subscribe2();
        publish.registered(subscribe1);
        publish.registered(subscribe2);
        publish.change("改变");
    }
}
