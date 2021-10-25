package com.snail.cloud.sc.demo.a;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DemoAConfiguration{

    /**
     * 声明swagger分组
     *
     * @return docket
     */
    @Bean
    public Docket demoADocket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("demoA")
                .select()
                .paths(PathSelectors.ant("/demoA/**"))
                .build();
    }

}