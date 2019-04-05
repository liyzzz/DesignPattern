package com.liyueze.servlet;

import com.liyueze.adapter.AnnotationHandlerAdapter;
import com.liyueze.adapter.HandlerAdapter;
import com.liyueze.adapter.HttpHandlerAdapter;
import com.liyueze.adapter.SimpleHandlerAdapter;
import com.liyueze.controller.SimpleController;

import java.util.ArrayList;
import java.util.List;

/**
 * 简略实现spring中DispatcherServlet的controller的适配
 * 工厂方法模式+单例模式+适配器模式
 */

public class DispatcherServlet {

    //饿汉单例模式
    private static List<HandlerAdapter> handlerAdapters = new ArrayList<>();

    static {
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
        handlerAdapters.add(new AnnotationHandlerAdapter());
    }

    public void doDispatch() {
//        此处模拟SpringMVC从request取handler的对象，仅仅new出，可以出，
//        不论实现何种Controller，适配器总能经过适配以后得到想要的结果
//        HttpController controller = new HttpController();
//        AnnotationController controller = new AnnotationController();
        SimpleController controller = new SimpleController();
        HandlerAdapter adapter=null;
        for (HandlerAdapter handlerAdapter : handlerAdapters) {
            if (handlerAdapter.support(controller)) {
                //得到对应适配器
                adapter= handlerAdapter;
            }
        }
        //通过适配器执行对应的controller对应方法
        if(adapter!=null){
            adapter.handle(controller);
        }
    }


}
