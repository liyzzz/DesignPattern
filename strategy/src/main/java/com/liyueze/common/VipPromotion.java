package com.liyueze.common;

public class VipPromotion implements Promotion {
    @Override
    public void doPromotion() {
        System.out.println("VIP客户打九折促销活动");
    }
}
