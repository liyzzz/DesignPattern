package com.liyueze.dynamicProxy.jdkDynamicProxy;

/**
 * cglib实现原理:
 * 是通过集成被代理类来实现动态代理的,因而类的修饰符不能含有final修饰符,并且方法同样不能使用static和final等修饰符,
 * 若含有就不能实现增强方法
 * jdk实现原理:
 * 代理对象和被代理对象必须同时实现同一接口(即含有同一套规范).
 *
 * CGLib底层采用ASM字节码生成框架，CGLib所创建的动态代理对象,在实际运行时候的性能要比JDK动态代理高不少
 * 而jdk是使用了反射，在生成代理类的时间上比CGLib少很多
 *
 * 总体上来看，jdk的动态代理在1.7以后比cglib快，在1.7之前cglib比jdk快
 *
 */
public class UserDao implements IDao {
    @Override
    public String save(String id)
    {
        if(id=="11"){
            throw new RuntimeException("没有此id");
        }
        System.out.println("-----核心业务：保存！！！------");
        return id;
    }
}
