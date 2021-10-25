package com.snail.cloud.demo.c.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DemoCApiConfiguration{

    public static final String APPLICATION = "demoC";

    /**
     * 声明swagger分组
     *
     * @return docket
     */
    @Bean
    public Docket demoCApiDocket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("demoCApi")
                .select()
                .paths(PathSelectors.ant("/demoCApi/**"))
                .build();
    }

}