package com.liyueze.guava;

import com.google.common.eventbus.Subscribe;
/**
 * 观察者
 */
public class GuavaEventRepeat {
    @Subscribe
    public void subscribe(String str){
        System.out.println("执行subscribe方法，传入的参数是：" + str);
    }
}
