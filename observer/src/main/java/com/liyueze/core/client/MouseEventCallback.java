package com.liyueze.core.client;

import com.liyueze.core.server.Event;
import com.liyueze.core.server.Target;

public class MouseEventCallback implements Target {

    public void onClick(Event e){
        System.out.println("===========触发鼠标单击事件==========" + "\n" + e);
    }

    public void onDoubleClick(Event e){
        System.out.println("===========触发鼠标双击事件==========" + "\n" + e);
    }

    public void onBlur(Event e){
        System.out.println("===========触发鼠标失焦事件==========" + "\n" + e);
    }

    public void onFocus(Event e){
        System.out.println("===========触发鼠标获焦事件==========" + "\n" + e);
    }
}
