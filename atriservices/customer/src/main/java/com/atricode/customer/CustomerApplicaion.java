package com.atricode.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CustomerApplicaion {
    public static void main(String args[]){
        SpringApplication.run(CustomerApplicaion.class, args);
    }
}
