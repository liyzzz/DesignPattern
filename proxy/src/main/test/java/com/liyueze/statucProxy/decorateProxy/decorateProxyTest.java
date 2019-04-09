package com.liyueze.statucProxy.decorateProxy;

import com.liyueze.staticProxy.decorateProxy.DecorateUserDaoProxy;
import com.liyueze.staticProxy.decorateProxy.IDao;
import com.liyueze.staticProxy.decorateProxy.UserDao;

public class decorateProxyTest {
    public static void main(String[] args) {
        IDao dao=new UserDao();
        dao=new DecorateUserDaoProxy(dao);
        dao.save("11");
    }
}
