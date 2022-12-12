package com.lopessystem.customer.service;

import com.lopessystem.customer.dto.CustomerRegistrationRequest;
import com.lopessystem.customer.model.Customer;
import com.lopessystem.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        // TODO check if email valid
        // TODO check if email not taken
        
        customerRepository.save(customer);
    }
}
