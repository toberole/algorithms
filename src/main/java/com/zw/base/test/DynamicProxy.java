package com.zw.base.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;
    private DynamicProxyInvocationHandler dynamicProxyInvocationHandler;

    public <T> T newProxyInstance(Object target, DynamicProxyInvocationHandler dynamicProxyInvocationHandler) {
        this.target = target;
        this.dynamicProxyInvocationHandler = dynamicProxyInvocationHandler;
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    @Override
    /**
     * proxy: 代理对象 com.sun.proxy.$Proxy0,$Proxy0、1、2 ...... 命名规律
     * method: 所要调用某个对象真实的方法的Method对象
     * args: 指代调用代理对象方法时传递的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (dynamicProxyInvocationHandler != null) {
            dynamicProxyInvocationHandler.onPreExecute(proxy, method, args);
        }
        Object o = method.invoke(target, args);
        if (dynamicProxyInvocationHandler != null) {
            dynamicProxyInvocationHandler.onAfterExecute(proxy, method, args);
        }
        return o;
    }

    public interface DynamicProxyInvocationHandler {
        void onPreExecute(Object proxy, Method method, Object[] args);

        void onAfterExecute(Object proxy, Method method, Object[] args);
    }
}
