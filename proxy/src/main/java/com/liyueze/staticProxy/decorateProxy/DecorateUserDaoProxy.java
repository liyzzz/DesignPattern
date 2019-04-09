package com.liyueze.staticProxy.decorateProxy;

public class DecorateUserDaoProxy implements IDao{
    private IDao dao;

    public DecorateUserDaoProxy(IDao dao) {
        this.dao = dao;
    }
    public void begin(){
        System.out.println("事务开启123");
    }
    public void end(){
        System.out.println("事务结束456");
    }

    public void exception(){
        System.out.println("目标方法中抛出的异常");
    }

    @Override
    public String save(String id) {
        begin();
        String rusult=null;
        try {
            rusult=this.dao.save(id);
        }catch (Exception e){
            exception();
        }
        end();
        System.out.println(rusult);
        return rusult;
    }
}
