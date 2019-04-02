package com.liyueze.common;

public class EmptyStrategy implements Promotion {
    @Override
    public void doPromotion() {
        System.out.println("未有任何促销活动");
    }
}
