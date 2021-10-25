package com.snail.cloud.demo.b;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DemoBConfiguration {

    /**
     * 声明swagger分组
     *
     * @return docket
     */
    @Bean
    public Docket demoBDocket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("demoB")
                .select()
                .paths(PathSelectors.ant("/demoB/**"))
                .build();
    }

}