package com.liyueze.abastractFactory;

import com.liyueze.common.ICourse;

public class MathJava implements ICourse {
    @Override
    public void study() {
        System.out.println("在数学系学习java课程使我快乐");
    }
}
