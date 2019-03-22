package com.liyueze.lazy;

/**
 * 通常在通用API中使用
 * 《Effective Java》一书中:
 * 单元素的枚举类型已经成为实现Singleton的最佳方法
 * 原因：见Test中EnumTest
 */
public enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance(){
        return INSTANCE;
    }
}
