package com.lopessystem.customer.service;

import com.lopessystem.customer.dto.CustomerRegistrationRequest;
import com.lopessystem.customer.dto.FraudCheckHistoryResponse;
import com.lopessystem.customer.model.Customer;
import com.lopessystem.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * The type Customer service.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class CustomerService {

    /**
     * The Customer repository.
     */
    private final CustomerRepository customerRepository;

    /**
     * The Rest template.
     */
    private final RestTemplate restTemplate;

    /**
     * Register customer.
     *
     * @param request the request
     */
    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        // TODO check if email valid
        // TODO check if email not taken
        customerRepository.saveAndFlush(customer);
        // TODO check if fraudster
        FraudCheckHistoryResponse response = restTemplate.getForObject(
                "http://localhost:7002/api/v1/fraud-check/{customerId}",
                FraudCheckHistoryResponse.class,
                customer.getId()
        );

        if (response.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // TODO send notification
    }
}
