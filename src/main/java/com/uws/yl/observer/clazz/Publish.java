package com.uws.yl.observer.clazz;

import com.uws.yl.observer.inter.ObServer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yelu
 * @ClassName Publish
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/14 0014下午 3:45
 */
public class Publish {

    private List<ObServer> obServerList = new ArrayList<>();

    public void registered(ObServer obServer){
        obServerList.add(obServer);
    }

    public void remove(ObServer obServer){
        obServerList.remove(obServer);
    }

    public void update(String name){
        obServerList.forEach(obServer -> obServer.update(name));
    }

    public void change(String name){
        this.update(name);
    }

}
