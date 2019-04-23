package com.liyueze.springAop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * 切面类
 */

@Component
//该注解相当于<aop:aspect ref="xmlProxy"></aop:config>
@Aspect
public class Proxy {

    /**
     * 表达式类型:
     *
     * (1) execution
     *
     * execution是使用的最多的一种Pointcut表达式，表示某个方法的执行，其标准语法如下。
     *
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern) throws-pattern?)
     * modifiers-pattern表示方法的访问类型，public等；
     *
     * ret-type-pattern表示方法的返回值类型，如String表示返回类型是String，“*”表示所有的返回类型；
     *
     * declaring-type-pattern表示方法的声明类，如“com.elim..*”表示com.elim包及其子包下面的所有类型；
     *
     * name-pattern表示方法的名称，如“add*”表示所有以add开头的方法名；
     *
     * param-pattern表示方法参数的类型，name-pattern(param-pattern)其实是一起的表示的方法集对应的参数类型，如“add()”表示不带参数的add方法，“add(*)”表示带一个任意类型的参数的add方法，“add(*,String)”则表示带两个参数，且第二个参数是String类型的add方法；
     *
     * throws-pattern表示异常类型；其中以问号结束的部分都是可以省略的。
     *
     * 1、“execution(* add())”匹配所有的不带参数的add()方法。
     * 2、“execution(public * com..*.add*(..))”匹配所有com包及其子包下所有类的以add开头的所有public方法。
     * 3、“execution(* *(..) throws Exception)”匹配所有抛出Exception的方法。
     * (2) within
     *
     * within是用来指定类型的，指定类型中的所有方法将被拦截。
     *
     * 1、“within(com.spring.aop.service.UserServiceImpl)”匹配UserServiceImpl类对应对象的所有方法外部调用，而且这个对象只能是UserServiceImpl类型，不能是其子类型。
     * 2、“within(com.elim..*)”匹配com.elim包及其子包下面所有的类的所有方法的外部调用。
     * (3) this
     *
     * Spring Aop是基于代理的，this就表示代理对象。this类型的Pointcut表达式的语法是this(type)，当生成的代理对象可以转换为type指定的类型时则表示匹配。基于JDK接口的代理和基于CGLIB的代理生成的代理对象是不一样的。
     *
     * 1、“this(com.spring.aop.service.IUserService)”匹配生成的代理对象是IUserService类型的所有方法的外部调用。
     * (4) target
     *
     * Spring Aop是基于代理的，target则表示被代理的目标对象。当被代理的目标对象可以被转换为指定的类型时则表示匹配。
     *
     * 1、“target(com.spring.aop.service.IUserService)”则匹配所有被代理的目标对象能够转换为IUserService类型的所有方法的外部调用。
     * (5) args
     *
     * args用来匹配方法参数的。
     *
     * 1、“args()”匹配任何不带参数的方法。
     * 2、“args(java.lang.String)”匹配任何只带一个参数，而且这个参数的类型是String的方法。
     * 3、“args(..)”带任意参数的方法。
     * 4、“args(java.lang.String,..)”匹配带任意个参数，但是第一个参数的类型是String的方法。
     * 5、“args(..,java.lang.String)”匹配带任意个参数，但是最后一个参数的类型是String的方法。
     * (6) @target
     *
     * @target匹配当被代理的目标对象对应的类型及其父类型上拥有指定的注解时。
     *
     * 1、“@target(com.spring.support.MyAnnotation)”匹配被代理的目标对象对应的类型上拥有MyAnnotation注解时。
     * (7) @args
     *
     * @args匹配被调用的方法上含有参数，且对应的参数类型上拥有指定的注解的情况。
     *
     * 1、“@args(com.spring.support.MyAnnotation)”匹配方法参数类型上拥有MyAnnotation注解的方法调用。如我们有一个方法add(MyParam param)接收一个MyParam类型的参数，而MyParam这个类是拥有注解MyAnnotation的，则它可以被Pointcut表达式“@args(com.elim.spring.support.MyAnnotation)”匹配上。
     * (8) @within
     *
     * @within用于匹配被代理的目标对象对应的类型或其父类型拥有指定的注解的情况，但只有在调用拥有指定注解的类上的方法时才匹配。
     *
     * 1、“@within(com.spring.support.MyAnnotation)”匹配被调用的方法声明的类上拥有MyAnnotation注解的情况。比如有一个ClassA上使用了注解MyAnnotation标注，并且定义了一个方法a()，那么在调用ClassA.a()方法时将匹配该Pointcut；如果有一个ClassB上没有MyAnnotation注解，但是它继承自ClassA，同时它上面定义了一个方法b()，那么在调用ClassB().b()方法时不会匹配该Pointcut，但是在调用ClassB().a()时将匹配该方法调用，因为a()是定义在父类型ClassA上的，且ClassA上使用了MyAnnotation注解。但是如果子类ClassB覆写了父类ClassA的a()方法，则调用ClassB.a()方法时也不匹配该Pointcut。
     * (9) @annotation
     *
     * @annotation用于匹配方法上拥有指定注解的情况。
     *
     * 1、“@annotation(com.spring.support.MyAnnotation)”匹配所有的方法上拥有MyAnnotation注解的方法外部调用。
     * (10) bean
     *
     * bean用于匹配当调用的是指定的Spring的某个bean的方法时。
     *
     * 1、“bean(abc)”匹配Spring Bean容器中id或name为abc的bean的方法调用。
     * 2、“bean(user*)”匹配所有id或name为以user开头的bean的方法调用。
     * 7.3.4 表达式组合
     *
     * 表达式的组合其实就是对应的表达式的逻辑运算，与、或、非。可以通过它们把多个表达式组合在一起。
     *
     * 1、“bean(userService) && args()”匹配id或name为userService的bean的所有无参方法。
     * 2、“bean(userService) || @annotation(MyAnnotation)”匹配id或name为userService的bean的方法调用，或者是方法上使用了MyAnnotation注解的方法调用。
     * 3、“bean(userService) && !args()”匹配id或name为userService的bean的所有有参方法调用。
     */
    @Pointcut("within(com.liyueze.springAop.dao..*)")//切入点————匹配com.liyueze.springAop.dao包下所有类的所有方法
    public  void testPointCut(){

    }

    @Before("testPointCut()")//前置通知: 目标方法之前执行
    public void begin(JoinPoint joinPoint)
    {
        System.out.println("事务开启123");
        System.out.println("------------------");
        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
        System.out.println("目标方法所属类的简单类名:" +        joinPoint.getSignature().getDeclaringType().getSimpleName());
        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            System.out.println("第" + (i+1) + "个参数为:" + args[i]);
        }
        System.out.println("被代理的对象:" + joinPoint.getTarget());
        System.out.println("代理对象自己:" + joinPoint.getThis());
        System.out.println("------------------");
    }

    @After("testPointCut()")//后置通知：目标方法之后执行（始终执行）
    public void end()
    {
        System.out.println("事务结束456");
        System.out.println("------------------");
    }

    @AfterReturning(returning = "returnArg",pointcut = "testPointCut()")// 返回后通知： 执行方法结束前执行(异常不执行)
    public void returning(Object returnArg)//returnArg是目标方法（代理）返回值
    {
        System.out.println("获取目标方法返回值:" + returnArg);
        System.out.println("------------------");
    }

    @AfterThrowing(throwing = "ex",pointcut = "testPointCut()")
    public void exception(Throwable ex)//ex是目标方法（代理）发生的异常
    {
        System.out.println("目标方法中抛出的异常:" + ex);
        System.out.println("记录异常...");
        System.out.println("------------------");
    }
/*
    @Around("testPointCut()")//环绕通知： 环绕目标方法执行
    public Object around(ProceedingJoinPoint pjd)//ProceedingJoinPoint对象是JoinPoint的子接口,该对象只用在@Around的切面方法中
    {
        Object result = null;
        try {
            //前置通知
            System.out.println("around目标方法执行前...");
            //执行目标方法
            //result = pjd.proeed();
            //用新的参数值执行目标方法
            result = pjd.proceed(new Object[]{"newId"});
            //返回通知
            System.out.println("around目标方法返回结果后..."+result);
        } catch (Throwable e) {
            //异常通知
            System.out.println("around执行目标方法异常后..."+e);
            throw new RuntimeException(e);
        }
        //后置通知
        System.out.println("around目标方法执行后...");

        return result;
    }
 */
}
