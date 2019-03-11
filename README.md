# DesignPattern 设计模式
* ## Factory Pattern 工厂模式:
        3w-what: 属于创建型模式，使用同一个接口指向创建的对象，对客户端屏蔽创建对象的逻辑
        3w-why: 简化创建逻辑(屏蔽创建过程)
        3w-how: 可以使用简单工厂模式，工厂方法模式，抽象工厂模式实现
    * ### SimpleFactory 简单工厂模式
            又名静态工厂方法（Static Factory Method）模式,但不属于23种GOF设计模式之一,简单工厂模式是工厂模式家族中最简单实用的模式
        * 模拟场景java,pyhon课程的创立<br>
        * 代码实现:见factory模块com.liyueze.simpleFactory包和com.liyueze.common包<br>
        * 测试类：在factory模块test下<br>
        * 类图：<br>  
![image](https://github.com/liyzzz/DesignPattern/blob/master/image/simpleFactory.png)<br>
**虚线箭头**:指向依赖,依赖是对象之间最弱的一种关联方式，是临时性的关联。代码中一般指由局部变量、函数参数、返回值建立的对于其他对象的调用关系。一个类调用被依赖类中的某些方法而得以完成这个类的一些职责<br>
**虚线三角**:指向接口；<br>
        * 优点：只需传入一个参数就可创建需要对象<br> 
        * 缺点：工厂类职责过重，当增加新产品时需要修改工厂类违背开闭原则，不易于扩展复杂的产品结构<br> 
        * 适宜场景：产品结构较简单,且较稳定<br> 