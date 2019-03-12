package com.liyueze.innerClass;
/*
 *学习内部类的demo
 *
 *《Think in java》中有这样一句话：使用内部类最吸引人的原因是：
 * 每个内部类都能独立地继承一个（接口的）实现，所以无论外围类是否已经继承了某个（接口的）实现，对于内部类都没有影响。
 *
 * 成员内部类、局部内部类、匿名内部类(经常用不做demo)和静态内部类
 */
/*
public class OutClass {
    *//*
     *成员内部类:和成员变量同级别
     * 注意：
     * 第一：成员内部类中不能存在任何static的变量和方法；
     * 第二：成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。
     *//*
    private int num=0;
    private static int count=1;

    public OutClass(int num) {
        this.num = num;
    }

    public void outFunction(){
        System.out.println("1111");
    }

    private class Inner{
        private int innerNum=0;
        *//*注意:static修饰的方法和变量只能在静态内部类中使用
        private static int innerCount=0;*//*

        public void test(){
            //内部类可以无节制的任意访问外部变量和方法
            System.out.println(num);
            System.out.println(count);
            outFunction();
        }
        *//*外部类的引用*//*
        public OutClass getInnerClass(){
            return OutClass.this;
        }
    }

    public static void main(String[] args) {
        OutClass innerClass=new OutClass(3);
        *//*注意创建语法：必须先创建外围类再new内部类*//*
        OutClass.Inner inner=innerClass.new Inner();
        //外部类调用内部类的变量和方法，必须先创建出成员内部类的实例才可以
        inner.test();
        System.out.println(inner.getInnerClass());
    }
}
*/

/*
public class OutClass{
    *//*
     *局部内部类：嵌套在方法和作用域内,和在方法或作用域中的变量一样
     * 它和成员内部类的区别在于:局部内部类的访问仅限于方法内或者该作用域内
     * 局部内部类和匿名内部类只能访问局部final变量
     *//*
    public void test(){
        System.out.println("outClass");
    }
    //定义在方法内
    public static OutClass getInenrclass(){
        //就和在方法中的变量中一样，无法使用public，private等修饰词
        class InnerClass extends OutClass{
            public void test(){
                System.out.println("innerClass");
            }
        }
        return new InnerClass();
    }

    public static void main(String[] args) {
        OutClass outClass=OutClass.getInenrclass();
        outClass.test();//输出innerClass
    }
}
*/

public class OutClass{
    /**
     * 静态内部类:使用static修饰的内部类
     */
    private int num =0;
    private static int count=1;
    static {
        System.out.println("static静态块");
    }

    public OutClass() {
        System.out.println("contructor");
    }

    public static class InnerClass{
        //可以申明非静态方法
        public int num1=0;
        public static int count1=2;
        static {
            System.out.println("innerStatic静态块");
        }

        public InnerClass() {
            System.out.println("InnerContructor");;
        }

        public static void testStatic(){
            System.out.println("innerStatic静态方法");
            /* 不可以调用外部非静态成员变量和方法
            System.out.println(num);*/
            System.out.println(count);
        }

        public void test(){
            /* 不可以调用外部非静态成员变量和方法
            System.out.println(num);*/
            System.out.println(count);
        }
    }

    public static void main(String[] args) {
        System.out.println(OutClass.count);//输出： static静态块    1
        Class clzz=OutClass.InnerClass.class;
        //意味着静态内部类不会在外部类加载的时候加载，而只会在使用的时候加载
        /*OutClass.InnerClass.testStatic();//此时输出: innerStatic静态块     innerStatic静态方法    1*/
        OutClass out=new OutClass();//输出 contructor
        //静态内部类 可以直接创建实例不需要依赖于外围类
        InnerClass innerClass=new InnerClass();//输出 InnerContructor
    }
}
