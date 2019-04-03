package com.liyueze.heroDecorator;

import com.liyueze.Entry.Hero;
import com.liyueze.IHero;
import com.liyueze.decorator.BFSDecorator;
import com.liyueze.decorator.NeedlesslyLargeRodDecorator;
import com.liyueze.decorator.UpgradeDecorator;

/**
 * 装饰器模式和策略模式都是持有引用，看起来实现类似。
 * 但是装饰器模式关注的是对引用的包装（扩展）
 * 而策略模式关注的是传递过来的引用（策略）执行的方法
 */

public class HeroDecoratorTest {

    public static void main(String[] args) {
        //vn英雄诞生
        IHero vn = new Hero(VnProperty.VN_HP,VnProperty.VN_MP,VnProperty.VN_AD,VnProperty.VN_AP);
        System.out.println("HP:"+vn.getHp());
        System.out.println("MP:"+vn.getMp());
        System.out.println("AD:"+vn.getAd());
        System.out.println("AP:"+vn.getAp());
        System.out.println("-------------购买暴风大剑---------------------");
        vn=new BFSDecorator(vn);
        System.out.println("HP:"+vn.getHp());
        System.out.println("MP:"+vn.getMp());
        System.out.println("AD:"+vn.getAd());
        System.out.println("AP:"+vn.getAp());
        System.out.println("--------------升级--------------------");
        vn=new UpgradeDecorator(vn);
        System.out.println("HP:"+vn.getHp());
        System.out.println("MP:"+vn.getMp());
        System.out.println("AD:"+vn.getAd());
        System.out.println("AP:"+vn.getAp());
        System.out.println("----------------升级------------------");
        vn=new UpgradeDecorator(vn);
        System.out.println("HP:"+vn.getHp());
        System.out.println("MP:"+vn.getMp());
        System.out.println("AD:"+vn.getAd());
        System.out.println("AP:"+vn.getAp());
        System.out.println("---------------购买无用大棒-------------------");
        vn=new NeedlesslyLargeRodDecorator(vn);
        System.out.println("HP:"+vn.getHp());
        System.out.println("MP:"+vn.getMp());
        System.out.println("AD:"+vn.getAd());
        System.out.println("AP:"+vn.getAp());
        System.out.println("----------------购买无用大棒------------------");
        vn=new NeedlesslyLargeRodDecorator(vn);
        System.out.println("HP:"+vn.getHp());
        System.out.println("MP:"+vn.getMp());
        System.out.println("AD:"+vn.getAd());
        System.out.println("AP:"+vn.getAp());
    }

    private interface VnProperty {
        //血量
        int VN_HP=550;
        //蓝量
        int VN_MP=350;
        //攻击力
        int VN_AD=68;
        //法术强度
        int VN_AP=0;
    }
}
