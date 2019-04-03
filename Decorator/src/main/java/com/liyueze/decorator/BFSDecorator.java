package com.liyueze.decorator;

import com.liyueze.IHero;

/**
 * 暴风大剑
 *  +30AD
 */
public class BFSDecorator extends HeroBaseDecorator{

    public BFSDecorator(IHero hero) {
        super(hero);
    }

    @Override
    public int getAd() {
        return super.getAd()+30;
    }
}
