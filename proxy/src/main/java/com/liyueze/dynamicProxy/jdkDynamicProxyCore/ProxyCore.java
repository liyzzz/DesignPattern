package com.liyueze.dynamicProxy.jdkDynamicProxyCore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyCore {
    public static final String ln = "\r\n";

    //返回代理的类
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,
                                          InvocationHandler h) throws IllegalArgumentException {

        return null;
    }

    /**
     * 用代码去生成代码
     * @param interfaces
     * @return
     */
    private static String generateSrc(Class<?>[] interfaces){
        StringBuffer sb = new StringBuffer();
        //打开包
        sb.append("package com.liyueze.dynamicProxy.jdkDynamicProxyCore;" + ln);
        //导入反射包
        sb.append("import java.lang.reflect.*;" + ln);
        //申明类
        sb.append("public class $Proxy0 implements ");
        for(Class<?> interfaze:interfaces){
            sb.append(interfaze.getName());
        }
        sb.append( "{" + ln);

        //开始写类的具体内容
        sb.append("InvocationHandleCore h;" + ln);
        //持有InvocationHandleCore的引用，在构造方法里传递
        sb.append("public $Proxy0(InvocationHandleCore h) { " + ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);
        //实现接口中每个的方法
        for (Method m : interfaces[0].getMethods()){
            //获取参数
            Class<?>[] params = m.getParameterTypes();
            //方法参数列表
            StringBuffer paramslist=new StringBuffer();
            for(Class<?> clazz:params){
                paramslist.append(clazz.getName()+" "+toLowerFirstCase(clazz.getSimpleName()));
            }
            //方法申明
            sb.append("public " +
                    //返回值类型
                    m.getReturnType().getName() + " "
                    //方法名
                    + m.getName() +
                    //方法参数列表
                    "(" +params + ") {" + ln);
            sb.append("try{" + ln);
        }


        sb.append("}" + ln);

        return sb.toString();
    }

    //首字母小写
    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
