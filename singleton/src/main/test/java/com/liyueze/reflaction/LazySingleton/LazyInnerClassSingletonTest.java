package com.liyueze.reflaction.LazySingleton;

import com.liyueze.lazy.LazyInnerClassSingleton;
import com.liyueze.lazy.LazySimpleSingleton;

import java.lang.reflect.Constructor;

public class LazyInnerClassSingletonTest {
    public static void main(String[] args) {
        LazyInnerClassSingleton lazyInnerClassSingleton=LazyInnerClassSingleton.getInstance();
        System.out.println(lazyInnerClassSingleton);
        try {
            Constructor constructor=LazyInnerClassSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            LazyInnerClassSingleton lazyInnerClassSingleton1=(LazyInnerClassSingleton)constructor.newInstance();
            System.out.println(lazyInnerClassSingleton1);
            System.out.println(lazyInnerClassSingleton==lazyInnerClassSingleton1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
