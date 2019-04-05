package com.liyueze.adapter;

//定义Adapter接口
public interface HandlerAdapter {
   boolean support(Object handle);
   void handle(Object handle);
}
