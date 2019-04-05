package com.liyueze.adapter;

import com.liyueze.controller.HttpController;

public class HttpHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean support(Object handle) {
        return handle instanceof HttpHandlerAdapter;
    }

    @Override
    public void handle(Object handle) {
        ((HttpController)handle).doHttpHandler();
    }
}
