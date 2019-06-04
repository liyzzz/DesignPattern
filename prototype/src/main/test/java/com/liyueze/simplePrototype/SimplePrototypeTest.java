package com.liyueze.simplePrototype;

import com.liyueze.simplePrototypee.PeoplePrototype;

public class SimplePrototypeTest {
    public static void main(String[] args) {
        PeoplePrototype peoplePrototype=new PeoplePrototype();
        peoplePrototype.setName(new StringBuilder("小明"));
        peoplePrototype.setAge(18);
        PeoplePrototype prototype=(PeoplePrototype)peoplePrototype.clone();
        System.out.println(prototype);
        //两者地址相同
        System.out.println(prototype.getName()==peoplePrototype.getName());
        //修改其中一个地址的对象
        peoplePrototype.getName().append("明");
        //另一个改变
        System.out.println(prototype);
        System.out.println(peoplePrototype);

    }
}
