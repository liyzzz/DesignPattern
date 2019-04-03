package com.liyueze.template;

public class GameTemplateTest {
    public static void main(String[] args) {
        LoLGamePlay gamePlay=new PlayEZ();
        gamePlay.doGame();
        System.out.println("-----游戏结束---------");
        LoLGamePlay gamePlay1=new PlayVN();
        gamePlay1.doGame();
    }
}
