package com.lopessystem.customer.controller;

import com.lopessystem.customer.dto.CustomerRegistrationRequest;
import com.lopessystem.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Customer controller.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    /**
     * The Customer service.
     */
    private final CustomerService customerService;

    /**
     * Create costumer.
     *
     * @param customerRegistrationRequest the customer registration request
     */
    @PostMapping
    public void createCostumer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("New costumer registration: {}", customerRegistrationRequest);

        customerService.registerCustomer(customerRegistrationRequest);
    }
}
