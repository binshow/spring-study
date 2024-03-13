package org.binshow.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "org.binshow")
@EnableAspectJAutoProxy // //作用等于 <aop:aspectj-autoproxy /> 配置类上开启 Aspectj注解支持!
public class MyConfig {
}
