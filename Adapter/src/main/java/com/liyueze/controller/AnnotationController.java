package com.liyueze.controller;

/**
 * 每一个Controller都有不同的方法，但是现在要统一接口调用，使用适配器
 */
public class AnnotationController {
    public void doAnnotationHandler(){
        System.out.println("annotation...");
    }
}
