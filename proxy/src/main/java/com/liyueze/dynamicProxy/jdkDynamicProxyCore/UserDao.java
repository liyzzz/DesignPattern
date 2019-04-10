package com.liyueze.dynamicProxy.jdkDynamicProxyCore;

/**
 * 自己实现jdk代理
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
