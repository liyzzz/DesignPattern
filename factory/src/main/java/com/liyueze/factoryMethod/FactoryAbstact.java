package com.liyueze.factoryMethod;

import com.liyueze.common.ICourse;

public abstract class FactoryAbstact {
    public void preCreat() {
        System.out.println("在准备课件");
    }

    public abstract ICourse creat();
}
