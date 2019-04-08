package com.liyueze.staticProxy.templeteProxy;

public abstract class UserDaoProxy {
    public void begin(){
        System.out.println("事务开启123");
    }
    public void end(){
        System.out.println("事务结束456");
    }

    public void exception(){
        System.out.println("目标方法中抛出的异常");
    }

    public abstract String save(String id);

    public void proxyMethod(String id){
        begin();
        String rusult=null;
        try {
            rusult=save(id);
        }catch (Exception e){
            exception();
        }
        end();
        System.out.println(rusult);
    }
}
