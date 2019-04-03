package com.liyueze.decorator;

import com.liyueze.IHero;

/**
 * 定义英雄装饰器(其他装饰器都继承此装饰器)
 */

public class HeroBaseDecorator implements IHero {

    //使用接口接收，这样各种装饰器都可以接收(只要实现接口的都可以接收)
    private IHero hero;

    public HeroBaseDecorator(IHero hero) {
        this.hero = hero;
    }

    @Override
    public int getHp() {
        return this.hero.getHp();
    }

    @Override
    public int getMp() {
        return this.hero.getMp();
    }

    @Override
    public int getAd() {
        return this.hero.getAd();
    }

    @Override
    public int getAp() {
        return this.hero.getAp();
    }
}
