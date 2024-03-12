package com.binshow._104springbootswagger.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


// 测试地址： http://localhost:8080/swagger-ui/index.html#
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    Docket docket(){
        return new Docket(DocumentationType.OAS_30).apiInfo(
                new ApiInfoBuilder().title("测试项目在线文档").description("binshow的测试").version("1.0").build())
                .select()
                //指定接口的位置
                .apis(RequestHandlerSelectors.basePackage("com.binshow._104springbootswagger.controller"))
                .build();
    }



}
