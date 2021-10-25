package com.snail.cloud.demo.b.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DemoBApiConfiguration{

    public static final String APPLICATION = "demoB";

    /**
     * 声明swagger分组
     *
     * @return docket
     */
    @Bean
    public Docket demoBApiDocket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("demoBApi")
                .select()
                .paths(PathSelectors.ant("/demoBApi/**"))
                .build();
    }

}