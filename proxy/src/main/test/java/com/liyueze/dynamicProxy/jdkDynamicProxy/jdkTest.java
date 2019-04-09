package com.liyueze.dynamicProxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;

public class jdkTest {
    public static void main(String[] args) {
        IDao userDao= new UserDao();
        InvocationHandler myInvocationHandler=new MyInvocationHandler();
        try {
            IDao proxyDao= (IDao) ((MyInvocationHandler) myInvocationHandler).getInstance(userDao);
            //执行方法(实际执行的代理对象的方法)
            proxyDao.save("33");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
