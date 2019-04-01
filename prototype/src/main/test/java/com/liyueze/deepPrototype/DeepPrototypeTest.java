package com.liyueze.deepPrototype;

public class DeepPrototypeTest {
    public static void main(String[] args) {
        DeepPeopleProtoType peoplePrototype=new DeepPeopleProtoType();
        peoplePrototype.setName(new StringBuilder("小明"));
        peoplePrototype.setAge(18);
        DeepPeopleProtoType prototype=(DeepPeopleProtoType)peoplePrototype.clone();
        System.out.println(prototype);
        //两者地址相同
        System.out.println(prototype.getName()==peoplePrototype.getName());
        //修改其中一个地址的对象
        peoplePrototype.getName().append("明");
        //另一个地址的对象随之改变
        //原因：java是值传递，copy的是地址。具体分析见博客https://www.cnblogs.com/hpyg/p/8005599.html
        System.out.println(prototype);
        System.out.println(peoplePrototype);
    }

}
