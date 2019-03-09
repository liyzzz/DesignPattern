package com.liyueze.abastractFactory;

import com.liyueze.common.ICourse;

public class MathDepartmentFactory implements DepartmentFactory {

    @Override
    public ICourse creatJava() {
        return new MathJava();
    }

    @Override
    public ICourse creatPython() {
        return new MathPython();
    }
}
