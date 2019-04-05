package com.liyueze.core;

import com.liyueze.core.client.Mouse;
import com.liyueze.core.client.MouseEventCallback;
import com.liyueze.core.client.MouseEventType;

public class CoreTest {
    public static void main(String[] args) {
        MouseEventCallback eventCallback=new MouseEventCallback();
        MouseEventCallback eventCallback1=new MouseEventCallback();
        Mouse mouse=new Mouse();
        mouse.addTarget(eventCallback,MouseEventType.ON_CLICK);
        mouse.addTarget(eventCallback1,MouseEventType.ON_CLICK);
        mouse.addTarget(eventCallback,MouseEventType.ON_BLUR);
        mouse.click();
        mouse.blur();
    }
}
