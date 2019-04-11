package com.liyueze.dynamicProxy.jdkDynamicProxyCode;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProxyCode {

    private static final String ln = "\r\n";
    private static final String PACKAGE="com.liyueze.dynamicProxy.jdkDynamicProxyCode";
    private static final String PROXY_CLASS_NAME="$Proxy0";

    //设置基本类型的映射关系
    private static Map<Class,Class> mappings = new HashMap<Class, Class>();
    static {
        //其他省略
        mappings.put(int.class,Integer.class);
    }

    //返回代理的类
    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,
                                          InvocationHandleCode h) throws IllegalArgumentException {
        try {
            //1、动态生成源代码.java文件
            String src = generateSrc(interfaces);
            //2.将java持久化，为后面编译成class文件做准备
            String filePath = ProxyCode.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();
            //3、把生成的.java文件编译成.class文件
            //获得java编译器
            JavaCompiler compiler=ToolProvider.getSystemJavaCompiler();

            // Java源文件管理类, 管理一系列JavaFileObject.
            //getStandardFileManager的参数依次是
            // 诊断监听器（若为null，则使用编译器的默认方法（既：idea的控制台）来报告诊断信息），
            // 格式化诊断信息时要应用的语言环境（如果为 null，则使用默认语言环境），
            // 用于解码字节的字符集（如果为 null，则使用平台默认的字符集）
            StandardJavaFileManager manager=compiler.getStandardFileManager(null, null, null);
            //这里可以传入多个file迭代：例如： manager.getJavaFileObjects(f,new File("Hello.java"));
            Iterable it = manager.getJavaFileObjects(f);
            //获取编译任务
            //参数的意思依次是：
            // out - 用于来自编译器的其他输出的 Writer；如果为 null，则使用 System.err
            //fileManager - 文件管理器；如果为 null，则使用编译器的标准文件管理器
            //diagnosticListener - 诊断侦听器；如果为 null，则使用编译器的默认方法报告诊断信息
            //options - 编译器选项；null 表示没有选项
            //classes - 类名称（用于注释处理），null 表示没有类名称
            //compilationUnits - 要编译的编译单元；null 表示没有编译单元
            CompilationTask task = compiler.getTask(null,manager,null,null,null,it);
            //执行编译
            task.call();
            //关闭fileManager
            manager.close();

            //4。将编译生产的。class文件加载到jvm中
            Class c=loader.loadClass(PACKAGE+"."+PROXY_CLASS_NAME);
            //因为编译生成的.class的文件在appClassLoader的加载路径中，所以不需要写新的类加载器
            //打印出传递过来的classLoader的加载路径，确实存在编译生成的.class的文件的路径
            /*URL[] urls=((URLClassLoader)loader).getURLs();
            for(URL url:urls){
                System.out.println(url);
            }*/
            Constructor constructor = c.getConstructor(InvocationHandleCode.class);
            f.delete();
            return constructor.newInstance(h);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

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
        sb.append("package "+PACKAGE+";" + ln);
        //导入反射包
        sb.append("import java.lang.reflect.*;" + ln);
        //申明类
        sb.append("public class "+PROXY_CLASS_NAME+" implements ");
        for(Class<?> interfaze:interfaces){
            sb.append(interfaze.getName());
        }
        sb.append( "{" + ln);

        //开始写类的具体内容
        sb.append("InvocationHandleCode h;" + ln);
        //持有InvocationHandleCore的引用，在构造方法里传递
        sb.append("public $Proxy0(InvocationHandleCode h) { " + ln);
        sb.append("this.h = h;");
        sb.append("}" + ln);
        //实现第一个接口中每个的方法
        for (Method m : interfaces[0].getMethods()) {
            //获取参数
            Class<?>[] params = m.getParameterTypes();
            //方法参数列表
            StringBuffer paramslist = new StringBuffer();
            //方法参数类型列表
            StringBuffer paramTypeslist = new StringBuffer();
            //方法参数名列表
            StringBuffer paramNameslist = new StringBuffer();
            for (Class<?> clazz : params) {
                paramTypeslist.append(clazz.getName()+".class" + ",");
                paramslist.append(clazz.getName() + " " + toLowerFirstCase(clazz.getSimpleName()) + ",");
                paramNameslist.append(toLowerFirstCase(clazz.getSimpleName()) + ",");
            }
            //删除最后一个逗号
            paramslist.delete(paramslist.length() - 1, paramslist.length());
            paramTypeslist.delete(paramTypeslist.length() - 1, paramTypeslist.length());
            paramNameslist.delete(paramNameslist.length() - 1, paramNameslist.length());
            //方法申明
            sb.append("public " +
                    //返回值类型
                    m.getReturnType().getName() + " "
                    //方法名
                    + m.getName() +
                    //方法参数列表
                    "(" + paramslist + ") {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramTypeslist.toString() + "});" + ln);
            //如果是void不返回，如果有返回值类型调用invocationHandle的invoke方法，并将其值返回回去
            sb.append(m.getReturnType() == void.class ? " " : "return ("+m.getReturnType().getName()+")");
            //调用invocationHandle的invoke方法
            sb.append("this.h.invoke(this,m,new Object[]{" + paramNameslist.toString() + "});" + ln);
            //抛出各种异常
            sb.append("}catch(Error _ex) { }");
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
            //接口中的某个方法实现结束
        }
        //整个类结束
        sb.append("}" + ln);
        return sb.toString();
    }

    //首字母小写
    private static String toLowerFirstCase(String src){
        char [] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private static String getReturnEmptyCode(Class<?> returnClass){
        if(mappings.containsKey(returnClass)){
            return "return 0;";
        }else if(returnClass == void.class){
            return "";
        }else {
            return "return null;";
        }
    }
}
