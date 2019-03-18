package com.liyueze.reflaction.hungrySingleton;

import com.liyueze.hungry.HungrySingleton;

import java.lang.reflect.Constructor;

public class HungrySingletonTest {
    public static void main(String[] args) {
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();

        Class clazz = HungrySingleton.class;
        //利用反射获取私有构造方法
        try {
            /*
             * getDeclaredConstructor:返回所有构造器，包括public的和非public的，当然也包括private的
             * getConstructor:只返回制定参数类型访问权限是public的构造器
             */
            Constructor c = clazz.getDeclaredConstructor(null);
            //强制访问
            c.setAccessible(true);
            //初始化
            HungrySingleton hungrySingleton2 = (HungrySingleton) c.newInstance();

            System.out.println(hungrySingleton1);
            System.out.println(hungrySingleton2);
            System.out.println(hungrySingleton1 == hungrySingleton2);
            /**
             * 结果：
             * com.liyueze.hungry.HungrySingleton@1fbc7afb
             * com.liyueze.hungry.HungrySingleton@45c8e616
             * false
             *
             * 结论：利用反射也成功破坏
             * 解决办法：修改单例的构造方法（见HungrySingleton）
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
