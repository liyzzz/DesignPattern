package com.liyueze.abastractFactory;

import com.liyueze.common.ICourse;

public class MathPython implements ICourse {
    @Override
    public void study() {
        System.out.println("在数学系学习python使我快乐");
    }
}
