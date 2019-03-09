package com.liyueze.abastractFactory;

import com.liyueze.common.ICourse;

public class ComputerPyhton implements ICourse {
    @Override
    public void study() {
        System.out.println("在计算机系学习python使我快乐");
    }
}
