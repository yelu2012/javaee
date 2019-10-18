package com.uws.yl.observer.clazz;

import com.uws.yl.observer.inter.ObServer;

/**
 * @author yelu
 * @ClassName Subscribe2
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/14 0014下午 3:55
 */
public class Subscribe2 implements ObServer {
    @Override
    public void update(String name) {
        System.out.println("消费者2得到通知"+name);
    }
}
