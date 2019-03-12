package com.liyueze.hungry;

public class HungrySingleton {
    //使用静态成员变量，在类加载时就已经产生
    //final修饰代表着首次初始化后不会被修改不会被修改
    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton() {
    }

    //加final是为了防止重写
    public final static HungrySingleton getInstance() {
        return hungrySingleton;
    }
}
