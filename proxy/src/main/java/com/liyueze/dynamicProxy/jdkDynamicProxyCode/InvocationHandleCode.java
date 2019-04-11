package com.liyueze.dynamicProxy.jdkDynamicProxyCode;

import java.lang.reflect.Method;

public interface InvocationHandleCode {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
