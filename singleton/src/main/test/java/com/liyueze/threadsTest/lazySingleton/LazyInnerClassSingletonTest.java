package com.liyueze.threadsTest.lazySingleton;

import com.liyueze.lazy.LazyInnerClassSingleton;

public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        Thread thread1=new Thread(()->{
            LazyInnerClassSingleton lazyInnerClassSingleton=LazyInnerClassSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+":"+lazyInnerClassSingleton);
        });

        Thread thread2=new Thread(()->{
            LazyInnerClassSingleton lazyInnerClassSingleton=LazyInnerClassSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+":"+lazyInnerClassSingleton);
        });
        thread1.start();
        thread2.start();
        System.out.println("end");

    }
}
