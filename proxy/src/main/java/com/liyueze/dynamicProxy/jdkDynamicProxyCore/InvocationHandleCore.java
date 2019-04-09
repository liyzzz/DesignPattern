package com.liyueze.dynamicProxy.jdkDynamicProxyCore;

import java.lang.reflect.Method;

public interface InvocationHandleCore {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
