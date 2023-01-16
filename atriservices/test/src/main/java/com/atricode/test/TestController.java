package com.atricode.test;

import com.atricode.clients.test.TestCheckResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    Logger log = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private TestService testService;

    @GetMapping("/{customerId}")
    public TestCheckResponse isFraudSter(@PathVariable("customerId") Integer customerId){
        log.info("Fraud check for customer :{}", customerId);
        return new TestCheckResponse(testService.isFraudCustomer(customerId));
    }

}

