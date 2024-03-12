package org.example;

import org.apache.commons.logging.LogFactory;
import org.example.config.Config;
import org.example.dao.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        User u1 = getBeanById(ctx);
        User u2 = getBeanByType(ctx);
        User u3 = getBeanByTypeAndId(ctx);

        // u1 == u2 == u3
        logger.info(u1.toString());
        logger.info(u2.toString());
        logger.info(u3.toString());
    }


    /**
     * 根据id获取bean
     */
    static User getBeanById(ApplicationContext ctx){
        User user = (User) ctx.getBean("user");
        logger.info("根据id获取bean: " + user.toString()); // org.example.dao.User@6f2cfcc2
        return user;
    }

    /**
     * 根据类型获取bean,要求IOC容器中指定类型的bean有且只能有一个!!
     * 不然会抛出错误
     */
    static User getBeanByType(ApplicationContext ctx){
        User user = ctx.getBean(User.class);
        logger.info("根据类型获取bean: " + user.toString()); // org.example.dao.User@6f2cfcc2
        return user;
    }


    /**
     * 根据类型和ID获取bean
     */
    static User getBeanByTypeAndId(ApplicationContext ctx){
        User user = ctx.getBean("user" , User.class);
        logger.info("根据类型和ID获取bean: " + user.toString()); // org.example.dao.User@6f2cfcc2
        return user;
    }

}
