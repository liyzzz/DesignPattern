package com.liyueze.reflaction.LazySingleton;

import com.liyueze.lazy.LazySimpleSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class LazySimpleSingletonTest {
    public static void main(String[] args) {
        LazySimpleSingleton lazySimpleSingleton=LazySimpleSingleton.getInstance();

        try {
            Constructor constructor=LazySimpleSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            LazySimpleSingleton lazySimpleSingleton1=(LazySimpleSingleton)constructor.newInstance();
            System.out.println(lazySimpleSingleton);
            System.out.println(lazySimpleSingleton1);
            System.out.println(lazySimpleSingleton==lazySimpleSingleton1);
            /**
             * 被反射破坏
             * 解决方法：在构造器里做文章（仿照hungrySingleton）
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
