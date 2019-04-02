package com.liyueze.general;

import com.liyueze.common.CashBackPromotion;
import com.liyueze.common.EmptyStrategy;
import com.liyueze.common.Promotion;
import com.liyueze.common.VipPromotion;

/**
 * 类似简单工厂的方式实现策略模式
 * 但是策略模式和工厂模式的侧重点不同，策略模式关注的对象的行为(执行的方法)，而简单工厂关注的是对象本身的创建
 */
public class GeneralStrategyClient {
    public static void strategyFactory(String promotionKey){
        Promotion promotion=null;
        if("VIP".equals(promotionKey)){
            promotion=new VipPromotion();
        }else if("CASH_BACK".equals(promotionKey)){
            promotion=new CashBackPromotion();
        }else{
            promotion=new EmptyStrategy();
        }
        promotion.doPromotion();
    }
}
