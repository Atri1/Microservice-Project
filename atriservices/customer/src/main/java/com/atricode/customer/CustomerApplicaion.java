package com.atricode.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {"com.atricode.customer",
                            "com.atricode.amqp"}
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.atricode.clients"
)
public class CustomerApplicaion {
    public static void main(String args[]){
        SpringApplication.run(CustomerApplicaion.class, args);
    }
}
