package com.lopessystem.customer.service;

import com.lopessystem.clients.fraud.FraudCheckResponse;
import com.lopessystem.clients.fraud.FraudClient;
import com.lopessystem.clients.notification.NotificationClient;
import com.lopessystem.clients.notification.NotificationRequest;
import com.lopessystem.customer.dto.CustomerRegistrationRequest;
import com.lopessystem.customer.model.Customer;
import com.lopessystem.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
     * The Fraud client.
     */
    private final FraudClient fraudClient;

    /**
     * The Notification client.
     */
    private final NotificationClient notificationClient;

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

        FraudCheckResponse response = fraudClient.isFraudster(customer.getId());

        if (response.getIsFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        // todo: make it async. i.e add to queue
        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to lopes services...",
                                customer.getFirstName())
                )
        );
    }
}
