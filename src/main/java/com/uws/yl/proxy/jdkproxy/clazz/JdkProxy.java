package com.uws.yl.proxy.jdkproxy.clazz;

import com.uws.yl.proxy.jdkproxy.inter.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author yelu
 * @ClassName JdkProxy
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/14 0014下午 1:56
 */
public class JdkProxy implements InvocationHandler {

    private Interceptor interceptor ;

    private Object target;

    public JdkProxy(Object target,Interceptor interceptor){
        this.target = target;
        this.interceptor = interceptor;
    }

    /**
    　* 产生代理对象
    　*/
    public static Object getProxyObject(Object target,Interceptor interceptor)  {
        JdkProxy jdkProxy = new JdkProxy(target, interceptor);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), jdkProxy);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        interceptor.before(proxy, method, args);
        Object object = method.invoke(target,args);
        interceptor.after(proxy, method, args);
        return object;
    }
}
