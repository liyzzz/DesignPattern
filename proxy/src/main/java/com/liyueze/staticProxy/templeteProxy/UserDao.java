package com.liyueze.staticProxy.templeteProxy;

public class UserDao extends TemplateUserDaoProxy {
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
