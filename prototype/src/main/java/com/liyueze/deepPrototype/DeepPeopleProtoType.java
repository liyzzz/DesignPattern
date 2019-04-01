package com.liyueze.deepPrototype;

import com.liyueze.common.Prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 深克隆:创建一个新对象，属性中引用的其他对象也会被克隆，不再指向原有对象地址。
 * 注意：不再指向原有对象地址
 * 实现方式：依靠输出流写出，再通过输入流读入。本例子是在内存中写出读入
 */

public class DeepPeopleProtoType implements Prototype,Serializable {
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

    /**
     * 原设备：
     *     键盘 System.in ，硬盘 FileStream，内存 ByteStream
     * 目的设备
     *     控制台 System.out ，硬盘 FileStream，内存ByteStream，
     *
     * @return
     */
    @Override
    public Prototype clone() {
        DeepPeopleProtoType peopleProtoType = null;
        ObjectOutputStream oos=null;
        ObjectInputStream ois=null;
        try {
            // 在内存中创建了可以增长的内存数据。该类是在内存缓存中，使用完之后触发GC回收，关流无效。
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
            //在内存中去读取定长的内存数据（传入bos的自动增长的ByteArray）
            ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            peopleProtoType = (DeepPeopleProtoType) ois.readObject();
        } catch (Exception e) {
            e.getStackTrace();
        } finally {
            try {
                if(oos!=null){
                    oos.close();
                }
                if(ois!=null){
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return peopleProtoType;
    }

    @Override
    public String toString() {
        return this.name+":"+this.age;
    }
}
