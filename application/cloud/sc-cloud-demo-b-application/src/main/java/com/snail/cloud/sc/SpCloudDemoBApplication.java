package com.snail.cloud.sc;

import indi.jl.sp.core.constant.CoreConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
@EnableFeignClients(basePackages = {CoreConstant.SCAN_PACKAGE_NAME, "com.snail"})
@ComponentScan(basePackages = {CoreConstant.SCAN_PACKAGE_NAME, "com.snail"})
public class SpCloudDemoBApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpCloudDemoBApplication.class, args);
    }
}
