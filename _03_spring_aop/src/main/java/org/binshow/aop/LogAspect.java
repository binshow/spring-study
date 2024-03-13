package org.binshow.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Aspect //  表示这个类是一个切面类
@Component
public class LogAspect {



    // @Before注解：声明当前方法是前置通知方法
    // value属性：指定切入点表达式，由切入点表达式控制当前通知方法要作用在哪一个目标方法上
    @Before(value = "execution(public int org.binshow.agent.CalculatorImpl.add(int,int))")
    public void printLogBeforeCore(JoinPoint joinPoint){
        System.out.println("[AOP前置通知] 方法开始了");

        // 根据 JoinPoint 对象就可以获取目标方法名称、实际参数列表
        Signature signature = joinPoint.getSignature(); // 获取方法签名

        String methodName = signature.getName();
        System.out.println(" --- methodName = " + methodName);

        int modifiers = signature.getModifiers();
        System.out.println(" --- modifiers = " + modifiers);

        String declaringTypeName = signature.getDeclaringTypeName();
        System.out.println(" --- declaringTypeName = " + declaringTypeName);

        Class declaringType = signature.getDeclaringType();
        System.out.println(" --- declaringType = " + declaringType.toString());


        Object[] args = joinPoint.getArgs(); // 获取外界调用目标方法时传入的实参列表
        System.out.println(" --- 实参列表 = " + Arrays.toString(new List[]{Arrays.asList(args)}));


    }


    //使用returning属性设置的名称在通知方法中声明一个对应的形参
    @AfterReturning(value = "execution(public int org.binshow.agent.CalculatorImpl.add(int,int))" ,
    returning = "targetMethodReturnValue")
    public void printLogAfterSuccess(JoinPoint joinPoint , Object targetMethodReturnValue) {
        System.out.println("[AOP返回通知] 方法成功返回了");
        String methodName = joinPoint.getSignature().getName();
        System.out.println(" --- methodName = " + methodName + ", return value = " + targetMethodReturnValue);
    }

    @AfterThrowing(value = "execution(public int org.binshow.agent.CalculatorImpl.add(int,int))" ,
    throwing = "targetMethodException")
    public void printLogAfterException(JoinPoint joinPoint , Throwable targetMethodException) {
        System.out.println("[AOP异常通知] 方法抛异常了");
        String methodName = joinPoint.getSignature().getName();
        System.out.println(" --- methodName = " + methodName + ", 抛出异常 = " + targetMethodException);

    }

    @After(value = "execution(public int org.binshow.agent.CalculatorImpl.add(int,int))")
    public void printLogFinallyEnd() {
        System.out.println("[AOP后置通知] 方法最终结束了");
    }


}
