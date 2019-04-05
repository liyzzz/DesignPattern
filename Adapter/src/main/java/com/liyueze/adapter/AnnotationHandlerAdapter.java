package com.liyueze.adapter;

import com.liyueze.controller.AnnotationController;

public class AnnotationHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean support(Object handle) {
        return handle instanceof AnnotationController;
    }

    @Override
    public void handle(Object handle) {
        ((AnnotationController)handle).doAnnotationHandler();
    }
}
