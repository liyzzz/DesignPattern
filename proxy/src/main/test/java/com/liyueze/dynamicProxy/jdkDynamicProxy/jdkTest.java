package com.liyueze.dynamicProxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;

public class jdkTest {
    public static void main(String[] args) {
        //设置jdk动态代理生成类保存成文件（文件的位置在项目根目录下com.sun.proxy）
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
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
