package com.liyueze.dynamicProxy.cglibDynamicProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib代理拦截器
 * 工厂方法,由每个MethodInterceptor自己生成代理对象
 */
public class MyMethodInterceptor implements MethodInterceptor {

    /**
     *
     * @param target 被代理的对象
     * @return
     */
    public Object getInstance(Object target){
        //cglib的enhancer类，增强器，对方法的拦截
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());//设置父类（既被代理的对象）
        enhancer .setCallback(this);//设置回调，是哪个MethodInterceptor拦截，就会生成该拦截器中的intercept方法执行内容
        return enhancer.create();//代理对象生成,使用默认无参数的构造函数创建目标对象
    }

    /**
     * 代理方法的执行内容
     * @param o 表示调用方法来自哪个对象（被代理对象）
     * @param method 表示代理的method对象
     * @param objects 表示此次调用的输入参数列表
     * @param methodProxy cglib封装的代理Method对象
     * @return 代理方法的返回值
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        begin();
        Object obj=methodProxy.invokeSuper(o,objects);
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
