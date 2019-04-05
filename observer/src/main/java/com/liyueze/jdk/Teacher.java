package com.liyueze.jdk;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {
    //老师姓名
    private String name;
    public Teacher(String name){
        this.name = name;
    }

    /**
     * 被观察者改变后触发的观察者的回调方法
     * @param o 被观察者
     * @param arg notifyObservers传递过过来的参数
     * 在这个例子中两个参数都是同一个
     */
    @Override
    public void update(Observable o, Object arg) {
        Question question_arg = (Question)arg;
        Question question_o = (Question)o;
        System.out.println("===============================");
        System.out.println(name + "老师，你好！\n" +
                "您收到了一个来自“" + question_arg.getUserName() + "”的提问，希望您解答，问题内容如下：\n" +
                question_arg.getContent() + "\n" +
                "提问者：" + question_o.getUserName());
    }
}
