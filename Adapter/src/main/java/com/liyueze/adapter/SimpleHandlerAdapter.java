package com.liyueze.adapter;

import com.liyueze.controller.SimpleController;

public class SimpleHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean support(Object handle) {
        return handle instanceof SimpleController;
    }

    @Override
    public void handle(Object handle) {
        ((SimpleController)handle).doSimplerHandler();
    }
}
