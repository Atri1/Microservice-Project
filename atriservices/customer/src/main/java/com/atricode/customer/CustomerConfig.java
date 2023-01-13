package com.atricode.customer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {

    @Bean("customer")
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
