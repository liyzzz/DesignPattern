package com.liyueze.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//Spring中的做法，就是用这种注册式单例

/**
 * 测试类未写
 * 原因：
 * 这只是一个工具，利用ContainerSingleton去创建其他类的单例。
 * 因为ioc是static的，所有类共有。所以通过ioc取得的类一定是单例的
 */

public class ContainerSingleton {
    private static Map<String,Object> ioc=new ConcurrentHashMap<>();
    private ContainerSingleton(){

    }
    public static Object getInstance(String className){
        synchronized (ioc){
            if(!ioc.containsKey(className)){
                Object obj=null;
                try {
                    obj=Class.forName(className).newInstance();
                    ioc.put(className,obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return obj;
            }else{
                return ioc.get(className);
            }
        }
    }
}
