package com.liyueze.factoryMethod;

import com.liyueze.common.ICourse;
import com.liyueze.common.JavaCourse;

public class JavaFactory extends FactoryAbstact {
    @Override
    public ICourse creat() {
        preCreat();
        return new JavaCourse();
    }
}
