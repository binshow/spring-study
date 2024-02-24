package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // 说明容器中是配置类
@ComponentScan("org.example")
public class Config {
}
