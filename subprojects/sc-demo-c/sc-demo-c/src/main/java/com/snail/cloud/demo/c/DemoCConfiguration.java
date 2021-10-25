package com.snail.cloud.demo.c;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DemoCConfiguration{

    /**
     * 声明swagger分组
     *
     * @return docket
     */
    @Bean
    public Docket demoCDocket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("demoC")
                .select()
                .paths(PathSelectors.ant("/demoC/**"))
                .build();
    }

}