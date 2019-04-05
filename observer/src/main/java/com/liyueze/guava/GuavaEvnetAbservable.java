package com.liyueze.guava;

import com.google.common.eventbus.EventBus;

/**
 * 被观察者
 */
public class GuavaEvnetAbservable {
    public void setChange1(){
        EventBus eventBus=new EventBus();
        eventBus.register(new GuavaEvent());
        eventBus.register(new GuavaEvent());
        //会根据post方法传递的参数，选择eventBus中register类中，具有相同类型参数(必须完全相同，子类父类都不可以)的注解方法
        eventBus.post("Analyze");
    }

    public void setChange2(){
        EventBus eventBus=new EventBus();
        eventBus.register(new GuavaEvent());
        eventBus.register(new GuavaEventRepeat());
        eventBus.post("Analyze");
    }

    public void setChange3(){
        EventBus eventBus=new EventBus();
        eventBus.register(new GuavaEvent());
        eventBus.register(new GuavaEventRepeat());
        eventBus.post(13);
    }

    /**
     * 会报空指针
     */
    /*public void setChange4(){
        EventBus eventBus=new EventBus();
        eventBus.register(new GuavaEvent());
        eventBus.register(new GuavaEventRepeat());
        eventBus.post(null);
    }*/

}
