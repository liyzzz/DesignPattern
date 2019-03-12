package com.liyueze.hungry;

public class HungryStaticSingleton {

    private static final HungryStaticSingleton hungryStaticSingleton;

    //使用静态块代码块初始化单例
    static {
        hungryStaticSingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
    }

    //加final是为了防止重写
    public final static HungryStaticSingleton getInstance() {
        return hungryStaticSingleton;
    }
}
