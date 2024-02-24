package org.example;

import org.example.config.Config;
import org.example.dao.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Hello world!
 *
 */


public class App {
    public static void main( String[] args ) {

        // 加载xml文件启动ioc容器
        //ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 加载配置类启动ioc容器
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        // 获取容器中的所有bean名称
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanDefinitionNames));



    }



    // 使用 xml 的方式来向 ioc 容器中注册 bean
    void iocXmlRegisterBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getAge());
    }






}
