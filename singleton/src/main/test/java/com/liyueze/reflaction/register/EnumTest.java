package com.liyueze.reflaction.register;

import com.liyueze.lazy.EnumSingleton;
import com.liyueze.lazy.LazySimpleSingleton;
import com.liyueze.serialize.common.SerializeUtil;

import java.lang.reflect.Constructor;

public class EnumTest {
    public static void main(String[] args) {
        EnumSingleton enumSingleton=EnumSingleton.getInstance();

        try {
            //枚举没有无参构造器，只有（String，int）的构造方法
            Constructor constructor=EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);
            EnumSingleton enumSingleton1=(EnumSingleton)constructor.newInstance("LiYueze",666);
            System.out.println(enumSingleton);
            System.out.println(enumSingleton1);
            System.out.println(enumSingleton==enumSingleton1);
            /**
             * 被反射破坏
             * 解决方法：在构造器里做文章（仿照hungrySingleton）
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**
 * 结果：
 * 报错
 * java.lang.IllegalArgumentException: Cannot reflectively create enum objects
 * 	at java.lang.reflect.Constructor.newInstance(Constructor.java:417)
 * 	at com.liyueze.reflaction.register.EnumTest.main(EnumTest.java:17)
 * 	解释：
 * 	代码片段(反射的newInstance方法)
 * 	public T newInstance(Object ... initargs)
 *         throws InstantiationException, IllegalAccessException,
 *                IllegalArgumentException, InvocationTargetException
 *     {
 *         if (!override) {
 *             if (!Reflection.quickCheckMemberAccess(clazz, modifiers)) {
 *                 Class<?> caller = Reflection.getCallerClass();
 *                 checkAccess(caller, clazz, null, modifiers);
 *             }
 *         }
 *         if ((clazz.getModifiers() & Modifier.ENUM) != 0)//如果此类含有ENUM修饰，调用该方法时会直接报错
 *             throw new IllegalArgumentException("Cannot reflectively create enum objects");
 *         ConstructorAccessor ca = constructorAccessor;   // read volatile
 *         if (ca == null) {
 *             ca = acquireConstructorAccessor();
 *         }
 *         @SuppressWarnings("unchecked")
 *         T inst = (T) ca.newInstance(initargs);
 *         return inst;
 *     }
 */

