package com.liyueze.decorator;

import com.liyueze.IHero;

/**
 * 无用大棒
 *  +60法强
 */
public class NeedlesslyLargeRodDecorator extends HeroBaseDecorator{

    public NeedlesslyLargeRodDecorator(IHero hero) {
        super(hero);
    }

    @Override
    public int getAp() {
        return super.getAp()+60;
    }
}
