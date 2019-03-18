package com.liyueze.threadsTest.HungrySingleton;

import com.liyueze.hungry.HungrySingleton;

/*
 * 饿汉模式，因为是static的，所以不会出现多线程创建多个对象的问题
 * 原因：在线程还没诞生的时候，就已经开始类的加载了，在类的加载过程中会加载静态的静态块变量方法。
 * 当线程访问时，静态成员变量已经初始化好了
 * */
public class HungrySingletonTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            HungrySingleton hungrySingleton = HungrySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + hungrySingleton);
        });
        Thread thread2 = new Thread(() -> {
            HungrySingleton hungrySingleton = HungrySingleton.getInstance();
            System.out.println(Thread.currentThread().getName() + ":" + hungrySingleton);
        });
        thread1.start();
        thread2.start();
        System.out.println("end");

    }
}
