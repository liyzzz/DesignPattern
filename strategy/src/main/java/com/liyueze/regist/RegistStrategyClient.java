package com.liyueze.regist;

import com.liyueze.common.CashBackPromotion;
import com.liyueze.common.EmptyStrategy;
import com.liyueze.common.Promotion;
import com.liyueze.common.VipPromotion;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用类似注册时单例的方式实现策略模式
 */

public class RegistStrategyClient {
    private static Map<String,Promotion> promotionMap=new HashMap<>();
    static {
        promotionMap.put(PromotionKey.VIP,new VipPromotion());
        promotionMap.put(PromotionKey.CASH_BACK,new CashBackPromotion());
        promotionMap.put(null,new EmptyStrategy());
    }

    public static void doPromotionStrategy(String promotionKey){
        promotionMap.get(promotionKey).doPromotion();
    }


    private interface PromotionKey{
        String VIP="VIP";
        String CASH_BACK="CASH_BACK";
    }
}
