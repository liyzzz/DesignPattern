package com.liyueze.dynamicProxy.cglibDynamicProxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.MethodInterceptor;

public class cglibTest {
    public static void main(String[] args) {
        UserDao userDao=new UserDao();
        MethodInterceptor myMethodInterceptor=new MyMethodInterceptor();
        //开启Debugg某事，将生成的class写入到F://cglib_proxy_classes
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"F://cglib_proxy_classes");
        UserDao userDaoProxy= (UserDao) ((MyMethodInterceptor) myMethodInterceptor).getInstance(userDao);
        userDaoProxy.save("1");
    }
}
