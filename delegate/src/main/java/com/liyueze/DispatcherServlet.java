package com.liyueze;

import com.liyueze.controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 简易实现dispatcherServlet(springmvc中DispatcherServlet就是以策略模式实现的)
 */

public class DispatcherServlet extends HttpServlet {
    private List<Handler> handleMapping = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        //这里实际应该是通过注解获取所有需要的类遍历加入handleMapping中，这里简单写成只有UserController;
        Class<?> clzz = UserController.class;
        try {
            Method[] methods = clzz.getMethods();
            for (Method method : methods) {
                Handler handler = new Handler();
                handler.setMethod(method);
                handler.setControll(clzz.newInstance());
                //假设url为"web/methodName.json"(实际是requestMapping)
                handler.setUri("web/" + method.getName() + ".json");
                handleMapping.add(handler);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过doDispatcherServlet方法将不同的请求分发给不同的controller
        doDispatcherServlet(req, resp);
    }


    private void doDispatcherServlet(HttpServletRequest req, HttpServletResponse resp) {
        //获取uri
        String uri = req.getRequestURI();


        Object returnObject = null;
        //遍历handleMapping找到相同url的Handle,通过反射调取方法
        for (Handler handler : handleMapping) {
            if (handler.getUri().equals(uri)) {
                try {
                    returnObject = handler.getMethod().invoke(handler.getControll(), req.getParameter("UserId"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }

        try {
            //这里简略写成通过response返回returnObject的toString。实际不是这样
            resp.getWriter().write(returnObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private class Handler {
        private Object Controll;
        private Method method;
        //一直到方法的整个url(类上的requestMapping+method上的requestMapping)
        private String Uri;

        public Object getControll() {
            return Controll;
        }

        public void setControll(Object controll) {
            Controll = controll;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getUri() {
            return Uri;
        }

        public void setUri(String uri) {
            Uri = uri;
        }
    }
}
