package com.multitap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MemberQueryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberQueryApplication.class, args);
    }

}
