package com.liyueze.abastractFactory;

import com.liyueze.common.ICourse;

public class ComputerJava implements ICourse {
    @Override
    public void study() {
        System.out.println("在计算机系学习java使我快乐");
    }
}
