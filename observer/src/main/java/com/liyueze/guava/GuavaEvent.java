package com.liyueze.guava;

import com.google.common.eventbus.Subscribe;

/**
 * 观察者
 */
public class GuavaEvent {
    @Subscribe
    public void subscribe1(String str){
        System.out.println("执行subscribe1方法，传入的参数是：" + str);
    }

    @Subscribe
    public void subscribe2(String str){
        System.out.println("执行subscribe2方法，传入的参数是：" + str);
    }

    //会报错,Subscribe注解要求至少含有一个方法参数
    /*@Subscribe
    public void subscribe3(){
        System.out.println("执行subscribe3方法");
    }*/

    @Subscribe
    public void subscribe4(Integer integer){
        System.out.println("执行subscribe4方法，传入的参数是:"+integer);
    }
}
