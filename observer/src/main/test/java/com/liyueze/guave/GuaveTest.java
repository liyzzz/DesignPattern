package com.liyueze.guave;

import com.liyueze.guava.GuavaEvnetAbservable;

public class GuaveTest {
    public static void main(String[] args) {
        GuavaEvnetAbservable abservable=new GuavaEvnetAbservable();
        abservable.setChange1();
        System.out.println("------------------");
        abservable.setChange2();
        System.out.println("------------------");
        abservable.setChange3();
    }
}
