package com.snail.cloud.demo.d.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DemoDApiConfiguration{

    /**
     * 声明swagger分组
     *
     * @return docket
     */
    @Bean
    public Docket demoDApiDocket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("demoDApi")
                .select()
                .paths(PathSelectors.ant("/demoDApi/**"))
                .build();
    }

}