package com.liyueze.simpleFactory;

import com.liyueze.common.ICourse;
import com.liyueze.common.JavaCourse;
import com.liyueze.common.PythonCourse;

public class Factory {
    public ICourse creatCourseByClass(Class<? extends ICourse> clzz) {
        if (null != clzz) {
            try {
                return clzz.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();

            }
        }
        System.out.println("您创建的课程不存在");
        return null;
    }

    public ICourse creatCourseByString(String courseName) {
        if (null != courseName) {
            courseName = courseName.toLowerCase();
        }
        switch (courseName) {
            case "java":
                return new JavaCourse();
            case "python":
                return new PythonCourse();
            default:
                System.out.println("您创建的课程不存在");
                return null;

        }

    }
}
