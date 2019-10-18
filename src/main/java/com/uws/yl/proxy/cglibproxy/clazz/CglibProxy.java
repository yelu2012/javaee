package com.uws.yl.proxy.cglibproxy.clazz;

import com.uws.yl.proxy.jdkproxy.inter.Interceptor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yelu
 * @ClassName CglibProxy
 * @ProjectName other
 * @Description: TODO
 * @date 2018/12/14 0014下午 3:03
 */
public class CglibProxy implements MethodInterceptor {

    private Interceptor interceptor;

    public CglibProxy(Interceptor interceptor) {
        this.interceptor = interceptor;
    }

    public static <T> T getProxy(Class<?> cls, Interceptor interceptor){
        return (T)Enhancer.create(cls, new CglibProxy(interceptor));
    }


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        this.interceptor.before(obj, method, args);
        Object object = proxy.invokeSuper(obj, args);
        this.interceptor.after(obj, method, args);
        return object;
    }
}
