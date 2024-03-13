package org.binshow.agent;


import org.springframework.stereotype.Component;

/**
 * 需求： 在 CalculatorImpl 中的每个实现方法都需要打印日志
 *
 *    1. 每个方法都需要写重复的代码，且和业务代码无关，有没有什么办法干掉这些一样的代码
 *     - 静态代理
 *     - 动态代理
 */


@Component
public class CalculatorImpl implements Calculator{
    @Override
    public int add(int i, int j) {
       // System.out.println("参数是：" + i + "," + j);
        int result = i + j;
        //System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
       // System.out.println("参数是：" + i + "," + j);
        int result = i - j;
        //System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
       // System.out.println("参数是：" + i + "," + j);
        int result = i * j;
       // System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        //System.out.println("参数是：" + i + "," + j);
        int result = i / j;
        //System.out.println("方法内部 result = " + result);
        return result;
    }
}
