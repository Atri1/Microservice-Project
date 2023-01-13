package com.atricode.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TestService {

    private final TestRepository testRepository;
    @Autowired
    public TestService(TestRepository testRepository){
        this.testRepository = testRepository;
    }
    public boolean isFraudCustomer(Integer customerId){
        TestCheckHistory testCheckHistory = new TestCheckHistory(customerId,
                false,
                LocalDateTime.now());
        testRepository.save(testCheckHistory);
        return false;
    }
}

