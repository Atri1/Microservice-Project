package com.atricode.customer;

import com.atricode.clients.notification.NotificationClient;
import com.atricode.clients.notification.NotificationRequest;
import com.atricode.clients.test.TestCheckResponse;
import com.atricode.clients.test.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private  final CustomerRepository customerRepository;
    @Qualifier("customer")
    private final RestTemplate restTemplate;
    private final TestClient testClient;
    private final NotificationClient notificationClient;

    @Autowired
    public CustomerService(CustomerRepository customerRepository,
                           RestTemplate restTemplate, TestClient testClient, NotificationClient notificationClient)
    {
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
        this.testClient = testClient;
        this.notificationClient = notificationClient;

    }
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest){
        Customer customer = new Customer(
                customerRegistrationRequest.getFirstName(),
                customerRegistrationRequest.getLastName(),
                customerRegistrationRequest.getEmail());
        customerRepository.saveAndFlush(customer);

//        TestCheckResponse testCheckResponse = restTemplate.getForObject
//                ("http://TEST/api/v1/test/{customerId}", TestCheckResponse.class, customer.getId());

        TestCheckResponse testCheckResponse = testClient.isFraudSter(customer.getId());

        if(testCheckResponse.getIsFraud()){
            throw new IllegalStateException("The person is fraud");
        } else {

            notificationClient.sendNotification(new NotificationRequest(customer.getId(),
                    customer.getEmail(),
                    "The user is not fraud"));
        }
    }
}
