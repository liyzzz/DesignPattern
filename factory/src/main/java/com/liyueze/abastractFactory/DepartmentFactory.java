package com.liyueze.abastractFactory;

import com.liyueze.common.ICourse;

public interface DepartmentFactory {
    ICourse creatJava();

    ICourse creatPython();
}
