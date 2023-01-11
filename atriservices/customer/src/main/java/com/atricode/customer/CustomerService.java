package com.atricode.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private  final CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public void registerCustimer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer = new Customer(customerRegistrationRequest.getId(),
                customerRegistrationRequest.getFirstName(),
                customerRegistrationRequest.getLastName(),
                customerRegistrationRequest.getEmail());
        customerRepository.save(customer);
    }
}
