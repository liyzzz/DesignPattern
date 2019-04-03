package com.liyueze.decorator;

import com.liyueze.IHero;

/**
 * 升级装饰器
 * 各种属性少量提升
 */
public class UpgradeDecorator extends HeroBaseDecorator {

    public UpgradeDecorator(IHero hero) {
        super(hero);
    }

    @Override
    public int getHp() {
        return super.getHp()+50;
    }

    @Override
    public int getMp() {
        return super.getMp()+30;
    }

    @Override
    public int getAd() {
        return super.getAd()+8;
    }

    @Override
    public int getAp() {
        return super.getAp()+5;
    }
}
