package com.liyueze.core.client;

import com.liyueze.core.server.EventListener;

/**
 * 被观察者
 */
public class Mouse extends EventListener {

    public void click(){
        System.out.println("调用单击方法");
        notifyTarget(MouseEventType.ON_CLICK);
    }

    public void doubleClick(){
        System.out.println("调用双击方法");
        notifyTarget(MouseEventType.ON_DOUBLE_CLICK);
    }

    public void blur(){
        System.out.println("调用获焦方法");
        notifyTarget(MouseEventType.ON_BLUR);
    }

    public void focus(){
        System.out.println("调用失焦方法");
        notifyTarget(MouseEventType.ON_FOCUS);
    }

}
