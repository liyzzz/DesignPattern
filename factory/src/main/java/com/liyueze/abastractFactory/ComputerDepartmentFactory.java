package com.liyueze.abastractFactory;

import com.liyueze.common.ICourse;

public class ComputerDepartmentFactory implements DepartmentFactory {
    @Override
    public ICourse creatJava() {
        return new ComputerJava();
    }

    @Override
    public ICourse creatPython() {
        return new ComputerPyhton();
    }
}
