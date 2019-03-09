package com.liyueze.common;

public class JavaCourse implements ICourse {
    public JavaCourse() {
        System.out.println("java");
    }

    @Override
    public void study() {
        System.out.println("学习java使我快乐");
    }
}
