package com.atricode.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class TestService {

    private final TestRepository testRepository;
    @Autowired
    public TestService(TestRepository testRepository){
        this.testRepository = testRepository;
    }
    public boolean isFraudCustomer(Integer customerId){

        log.info("Inside testService");
        TestCheckHistory testCheckHistory = new TestCheckHistory(customerId,
                false,
                LocalDateTime.now());
        testRepository.save(testCheckHistory);
        return false;
    }
}

