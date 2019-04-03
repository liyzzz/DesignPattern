package com.liyueze.Entry;

import com.liyueze.IHero;

/**
 * 英雄联盟某个英雄
 */
public class Hero implements IHero {
    //血量
    private int hp;
    //蓝量
    private int mp;
    //攻击力
    private int ad;
    //法术强度
    private int ap;

    public Hero(int hp, int mp, int ad, int ap) {
        this.hp = hp;
        this.mp = mp;
        this.ad = ad;
        this.ap = ap;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getAd() {
        return ad;
    }

    public int getAp() {
        return ap;
    }
}
