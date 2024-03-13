package org.binshow.agent;

import org.junit.jupiter.api.Test;

public class AgentTest {


    /**
     * 动态代理测试类
     */
    @Test
    void testDynamicProxy(){
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.add(1,3);

    }
}
