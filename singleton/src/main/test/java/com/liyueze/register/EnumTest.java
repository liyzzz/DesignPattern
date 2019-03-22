package com.liyueze.register;

import com.liyueze.lazy.EnumSingleton;

/**
 * enum是线程绝对安全的
 */
public class EnumTest {
    public static void main(String[] args) {
        Thread thread1=new Thread(()->{
            EnumSingleton enumSingleton=EnumSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+":"+enumSingleton);
        });

        Thread thread2=new Thread(()->{
            EnumSingleton enumSingleton=EnumSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+":"+enumSingleton);
        });
        thread1.start();
        thread2.start();
        System.out.println("end");
    }
}
