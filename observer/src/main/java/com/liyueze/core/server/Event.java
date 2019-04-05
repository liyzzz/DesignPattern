package com.liyueze.core.server;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 事件是将观察者和被观察者关联起来的封装
 */
public class Event {

    //事件源，事件是由谁发起的保存起来，被观察者
    private EventListener source;
    //事件触发，要通知谁,观察者
    private List<Target> targets=new ArrayList<>();
    //事件触发，要做什么动作，回调
    private Method callback;
    //事件的名称，触发的是什么事件
    private String trigger;
    //事件触发的时间
    private long time;

    public Event(Target target, Method callback,EventListener source,String trigger) {
        this.targets.add(target);
        this.callback = callback;
        this.source=source;
        this.trigger=trigger;
    }
    public Event(List<Target> targets, Method callback,EventListener source) {
        this.targets=targets;
        this.callback = callback;
    }

    public void setSource(EventListener source) {
        this.source = source;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Object getSource() {
        return source;
    }

    public List<Target> getTargets() {
        return targets;
    }

    public void addTargets(Target target) {
        this.targets.add(target);
    }

    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }

    public long getTime() {
        return time;
    }


    public Method getCallback() {
        return callback;
    }

    @Override
    public String toString() {
        return "Event{" + "\n" +
                "\tsource=" + source.getClass() + ",\n" +
                "\ttarget=" + targets.getClass() + ",\n" +
                "\tcallback=" + callback + ",\n" +
                "\ttrigger='" + trigger + "',\n" +
                "\ttime=" + time + "'\n" +
                '}';
    }
}
