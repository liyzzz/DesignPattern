package com.liyueze.activity;

import com.liyueze.common.Promotion;

public class StrategyActivity {
    private Promotion promotion;

    public StrategyActivity(Promotion promotion) {
        this.promotion = promotion;
    }

    public void doStrategy(){
        promotion.doPromotion();
    }
}
