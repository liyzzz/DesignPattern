package com.liyueze.jdk;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个被观察者被多个观察者监听
 */
public class ObserverTest {
    public static void main(String[] args) {
        List<Teacher> teachers=new ArrayList<>();
        teachers.add(new Teacher("大明"));
        teachers.add(new Teacher("大大明"));
        Question question=new Question();
        question.setUserName("小明");
        question.setContent("什么是观察者模式");
        question.publishQuestion(teachers);
    }
}
