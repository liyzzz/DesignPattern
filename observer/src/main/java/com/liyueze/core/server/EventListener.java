package com.liyueze.core.server;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 监听器，它就是被观察者
 */
public class EventListener {

    protected Map<String, Event> events = new HashMap<String, Event>();

    public void addTarget(Target target, String trigger) {
        Method callback = getCallback(target, trigger);
        Event event = new Event(target, callback, this, trigger);
        if (events.containsKey(trigger)) {
            events.get(trigger).addTargets(target);
        } else {
            events.put(trigger, event);
        }
    }


    public Method getCallback(Target target, String trigger) {
        Method callback = null;
        try {
            callback = target.getClass().getMethod("on" + toUpper(trigger),Event.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (callback != null) {
            return callback;
        } else {
            throw new RuntimeException("未找见回调方法");
        }
    }

    public void notifyTarget(String trigger) {
        Event event = events.get(trigger);
        Method callback = event.getCallback();
        List<Target> traget = event.getTargets();
        if (event == null && callback == null && traget == null) {
            throw new RuntimeException("不存在当前观察者");
        }
        try {
            for(Target target:traget){
                callback.invoke(target, event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toUpper(String str) {
        if (str == null && str == "") {
            throw new RuntimeException("事件的名称为空");
        }
        char[] strChars = str.toCharArray();
        strChars[0]-=32;
        return String.valueOf(strChars);
    }

}
