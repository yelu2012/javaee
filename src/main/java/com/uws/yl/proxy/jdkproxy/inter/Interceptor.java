package com.uws.yl.proxy.jdkproxy.inter;

import java.lang.reflect.Method;

/**
  *  拦截器 可以植入代理对象中
　*/
public interface Interceptor {
    void before(Object proxy, Method method ,Object[] args);

    void after(Object proxy, Method method ,Object[] args);

    void around(Object proxy, Method method ,Object[] args);
}
