package com.atricode.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private  final CustomerRepository customerRepository;
    @Qualifier("customer")
    private final RestTemplate restTemplate;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate)
    {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;

    }
    public void registerCustimer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer = new Customer(
                customerRegistrationRequest.getFirstName(),
                customerRegistrationRequest.getLastName(),
                customerRegistrationRequest.getEmail());
        customerRepository.saveAndFlush(customer);
        TestCheckResponse testCheckResponse = restTemplate.getForObject
                ("http://localhost:8081/api/v1/test/{customerId}", TestCheckResponse.class, customer.getId());

        if(testCheckResponse.getIsFraud()){
            throw new IllegalStateException("The person is fraud");
        }
    }
}
