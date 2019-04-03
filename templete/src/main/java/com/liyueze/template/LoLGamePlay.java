package com.liyueze.template;

/**
 * LOL游戏模板
 * 1.排队等待
 * 2.选择英雄
 * 3.游戏初始化
 * 4.快乐的玩耍
 */

public abstract class LoLGamePlay {

    protected void waitQueue(){
        System.out.println("排队等待ing");
    }

    protected abstract void changeHero();

    protected void gameInit(){
        System.out.println("游戏初始化ing");
    }

    protected void gamePlay(){
        System.out.println("愉快的玩耍ing");
    }

    public void doGame(){
        waitQueue();
        changeHero();
        gameInit();
        gamePlay();
    }

}
