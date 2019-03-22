package com.liyueze.hungry;

/**
 * 因为HungryStaticSingleton只是在HungrySingleton的基础上变成了静态块，测试结果不变，所以测试用例不再重复写
 */
public class HungryStaticSingleton {

    private static final HungryStaticSingleton hungryStaticSingleton;

    //使用静态块代码块初始化单例
    static {
        hungryStaticSingleton = new HungryStaticSingleton();
    }

    private HungryStaticSingleton() {
        /**
         * 防止被反射破坏
         */
        synchronized(HungryStaticSingleton.class) {
            if (hungryStaticSingleton != null) {
                throw new RuntimeException("单例正在被反射破坏");
            }
        }
    }

    //加final是为了防止重写
    public final static HungryStaticSingleton getInstance() {
        return hungryStaticSingleton;
    }

    //防止被序列化破坏
    private  Object readResolve(){
        return  hungryStaticSingleton;
    }

}
