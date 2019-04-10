package com.liyueze.dynamicProxy.jdkDynamicProxyCore;

import java.lang.reflect.Method;

/**
 * 自己实现jdk的代理处理器，可以代理任意一个对象
 * 工厂方法,由每个InvocationHandler自己生成代理对象
 */

public class MyInvocationHandler implements InvocationHandleCore {

    //被代理的对象，可以是任意一个对象
    private Object target;

    //返回的是代理的对象
    public Object getInstance(Object target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();
        //第一个参数是指定代理类的类加载器
        //第二个参数是代理类需要实现的接口）
        //第三个参数是invocation handler，用来处理方法的调用。这里传入我们自己实现的handler
        return ProxyCore.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    /**
     * 重写InvocationHandler的invoke方法就是用来对代理对象方法做处理
     * 也就是代理对象的逻辑
     * @param proxy  jdk生成的动态代理的对象
     * @param method 被代理的方法
     * @param args   被代理的方法的参数
     * @return 代理方法执行后的返回值
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        begin();
        Object obj=method.invoke(this.target,args);
        System.out.println("代理的对象是："+proxy.getClass().getName());
        end();
        return obj;
    }

    public void begin(){
        System.out.println("事务开启123");
    }
    public void end(){
        System.out.println("事务结束456");
    }
}
