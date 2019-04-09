package com.liyueze.statucProxy.templeteProxy;

import com.liyueze.staticProxy.templeteProxy.UserDao;
import com.liyueze.staticProxy.templeteProxy.TemplateUserDaoProxy;

public class ProxyTest {
    public static void main(String[] args) {
        TemplateUserDaoProxy userDao=new UserDao();
        userDao.proxyMethod("11");
    }
}
