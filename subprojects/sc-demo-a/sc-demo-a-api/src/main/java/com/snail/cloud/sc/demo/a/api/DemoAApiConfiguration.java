package com.snail.cloud.sc.demo.a.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DemoAApiConfiguration{

    /**
     * 声明swagger分组
     *
     * @return docket
     */
    @Bean
    public Docket demoAApiDocket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("demoAApi")
                .select()
                .paths(PathSelectors.ant("/demoAApi/**"))
                .build();
    }

}