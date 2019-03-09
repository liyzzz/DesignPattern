package com.liyueze.factoryMethod;

import com.liyueze.common.ICourse;
import com.liyueze.common.PythonCourse;

public class PythonFactory extends FactoryAbstact {
    @Override
    public ICourse creat() {
        preCreat();
        return new PythonCourse();
    }
}
