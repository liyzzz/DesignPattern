package com.liyueze.hungry;

import java.io.Serializable;

/**
 * 为测试序列化破坏单例，实现Serializable接口
 */
public class HungrySingleton implements Serializable {
    //使用静态成员变量，在类加载时就已经产生
    //final修饰代表着首次初始化后不会被修改不会被修改
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
        /**
         * 防止反射破坏
         * synchronized枷锁为了防止多线程（但在饿汉模式中可以不加，因为是static的）
         * synchronized(class)是类锁
         */
        /*synchronized(HungrySingleton.class){
            if(hungrySingleton !=null){
                throw new RuntimeException("单例正在被反射破坏");
            }
        }*/
    }

    //加final是为了防止重写
    public final static HungrySingleton getInstance() {
        return hungrySingleton;
    }

    //可以防止序列化破坏单例的方法
    //注意：！！！这个里返回值必须是Object
//    private  Object readResolve(){
//        return  hungrySingleton;
//    }
}
