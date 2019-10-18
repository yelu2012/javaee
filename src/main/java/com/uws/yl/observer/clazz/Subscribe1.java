package com.uws.yl.observer.clazz;

import com.uws.yl.observer.inter.ObServer;

/**
 * @author yelu
 * @ClassName Subscribe1
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/14 0014下午 3:50
 */
public class Subscribe1 implements ObServer {


    @Override
    public void update(String name) {
        System.out.println("消费者1得到通知"+name);
    }
}
