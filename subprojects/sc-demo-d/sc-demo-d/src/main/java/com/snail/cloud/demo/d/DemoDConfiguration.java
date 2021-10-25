package com.snail.cloud.demo.d;

import com.snail.cloud.demo.b.api.BApi;
import indi.jl.sp.security.api.SpAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DemoDConfiguration {

    public static final String SCAN_PACKAGE_NAME = "com.snail";

    @Autowired
    private BApi bApi;

    @Scheduled(cron = "*/5 * * * * ?")
    public void testAnno() {
        SpAuthentication.setSecretToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IlNFQ1JFVCJ9.eyJleHAiOiIyMjk1LTA4LTA0IDE0OjUxOjEzIiwidXNlcklkIjoxLCJ1c2VyTmFtZSI6ImFkbWluIiwibmFtZSI6IueuoeeQhuWRmCIsInJvbGVzIjpbeyJyb2xlSWQiOjEsIm5hbWUiOiJ0ZXN0In1dLCJyZXNvdXJjZXMiOlt7Im1ldGhvZCI6IkdFVCIsInVybCI6Ii8qKiIsImF1dGhvcml0eSI6IkdFVDovKioiLCJhdHRyaWJ1dGUiOiJHRVQ6LyoqIn0seyJtZXRob2QiOiJQT1NUIiwidXJsIjoiLyoqIiwiYXV0aG9yaXR5IjoiUE9TVDovKioiLCJhdHRyaWJ1dGUiOiJQT1NUOi8qKiJ9XSwiZXh0TWVzc2FnZSI6e319.NBElxXuASpKcIobC2JA5I-e-mBa4f-oKKr7CavQfZwo");
        bApi.get(1L);
    }

    /**
     * 声明swagger分组
     *
     * @return docket
     */
    @Bean
    public Docket demoDDocket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("demoD")
                .select()
                .paths(PathSelectors.ant("/demoD/**"))
                .build();
    }

}