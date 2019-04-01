package com.liyueze.simplePrototypee;

import com.liyueze.common.Prototype;

/**
 * 浅克隆:创建一个新对象，新对象的属性和原来对象完全相同，对于非基本类型属性，仍指向原有属性所指向的对象的内存地址。
 * 注意：对于非基本类型属性，克隆新对象的属性仍指向原有属性所指向的对象的内存地址
 * 原因：java是值传递，具体见博客https://www.cnblogs.com/liqiangchn/p/9465186.html
 *
 * 浅克隆也是最经常使用的克隆方式
 */
public class PeoplePrototype implements Prototype {
    private StringBuilder name;
    private Integer age;

    public StringBuilder getName() {
        return name;
    }

    public void setName(StringBuilder name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public Prototype clone() {
        PeoplePrototype prototype=new PeoplePrototype();
        prototype.setAge(this.age);
        //clone到的是地址
        prototype.setName(this.name);
        return prototype;
    }

    @Override
    public String toString() {
        return this.name+":"+this.age;
    }


}
