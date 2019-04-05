package com.liyueze.jdk;


import java.util.List;
import java.util.Observable;

public class Question extends Observable {
    //提问者姓名
    private String userName;
    //问题内容
    private String content;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void publishQuestion(List<Teacher> teachers){
        System.out.println(this.getUserName() + "提交了一个问题。");
        for(Teacher teacher:teachers){
            //加入Observer
            addObserver(teacher);
        }
        setChanged();
        //可以向观察者传递消息(notifyObservers的参数)
        notifyObservers(this);

    }
}
