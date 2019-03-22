package com.liyueze.threadsTest.lazySingleton;

import com.liyueze.lazy.LazySimpleSingleton;

public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        Thread thread1=new Thread(()->{
            LazySimpleSingleton lazySimpleSingleton=LazySimpleSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+":"+lazySimpleSingleton);
        });

        Thread thread2=new Thread(()->{
            LazySimpleSingleton lazySimpleSingleton=LazySimpleSingleton.getInstance();
            System.out.println(Thread.currentThread().getName()+":"+lazySimpleSingleton);
        });
        thread1.start();
        thread2.start();
        System.out.println("end");

    }
}
