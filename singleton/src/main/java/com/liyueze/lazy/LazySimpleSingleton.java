package com.liyueze.lazy;

import java.io.Serializable;

/*public class LazySimpleSingleton implements Serializable {
    *//**
     * 必须是static的，所有类公用。
     * 否则一个类一个lazySimpleSingleton
     *//*
    private static LazySimpleSingleton lazySimpleSingleton;

    private LazySimpleSingleton(){

    }

    *//**
     * synchronized修饰是为了防止多线程破话
     * 举例：
     * 当线程A进入if判断里(还未new和赋值)，线程A的时间片结束，线程B也同时走到了if判断，发现lazySimpleSingleton还是null,又再次走进了if判断里
     * 这个时候就会出现两个线程创建了不同的lazySimpleSingleton
     *//*
    public synchronized static LazySimpleSingleton getInstance(){
        if(lazySimpleSingleton ==null){
            lazySimpleSingleton=new LazySimpleSingleton();
            //1.分配内存给这个对象
            //2.初始化对象
            //3.设置lazySimpleSingleton指向刚分配的内存地址
            //4.初次访问对象
        }
        return lazySimpleSingleton;
    }
    //  防止序列化破坏单利
    private Object readResolve(){
        return lazySimpleSingleton;
    }
}*/

/**
 * 上面的写法有一点不好：使用了synchronized关键字，而且是加载方法上，这样会导致降低性能
 *
 * 以下是改进版：DoubleCheck
 */
public class LazySimpleSingleton {

    private static LazySimpleSingleton lazySimpleSingleton;

    private LazySimpleSingleton(){

    }

    public  static LazySimpleSingleton getInstance(){
        /**
         * 采用双重if
         * 原因：
         * 如果去掉外面的if判断，就和上面的写法一样，这线程一进方法就被锁住，和在方法上加锁一样
         * 里面的if是为了当线程A进入外层if（lazySimpleSingleton =null）时，时间片耗尽。
         * 线程B发现lazySimpleSingleton还是null,一样进入if里。这时两个线程又会创建不同的对象了
         * 好处：
         * 当去掉外层的if时，相当于当一个线程进入方法后，其他线程都在阻塞状态，等着释放锁。
         * 而双重检验只有在lazySimpleSingleton ==null的时候才会出现阻塞，其他时候不会走synchronized块，提升效率
         */
        if(lazySimpleSingleton ==null){
            synchronized (LazySimpleSingleton.class){
                if(lazySimpleSingleton==null){
                    lazySimpleSingleton=new LazySimpleSingleton();
                }
            }
        }
        return lazySimpleSingleton;
    }
    //  防止序列化破坏单利
    private LazySimpleSingleton readResolve(){
        return lazySimpleSingleton;
    }
}


