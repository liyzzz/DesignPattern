package com.liyueze.common;

public class PythonCourse implements ICourse {
    public PythonCourse() {
        System.out.println("python");
    }

    @Override
    public void study() {
        System.out.println("学习python使我快乐");
    }
}
