package com.atricode.clients.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("test")
public interface TestClient {

    @GetMapping("/api/v1/test/{customerId}")
    public TestCheckResponse isFraudSter(@PathVariable("customerId") Integer customerId);
}
