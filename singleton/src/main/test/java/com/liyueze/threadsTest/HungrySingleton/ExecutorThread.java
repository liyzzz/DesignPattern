package com.liyueze.threadsTest.HungrySingleton;

import com.liyueze.hungry.HungrySingleton;

public class ExecutorThread implements Runnable{
    @Override
    public void run() {
        HungrySingleton hungrySingleton=HungrySingleton.getInstance();
        System.out.println(Thread.currentThread().getName()+":"+hungrySingleton);
    }
}
