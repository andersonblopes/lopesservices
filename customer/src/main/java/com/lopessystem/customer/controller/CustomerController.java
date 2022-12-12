package com.lopessystem.customer.controller;

import com.lopessystem.customer.dto.CustomerRegistrationRequest;
import com.lopessystem.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void createCostumer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("New costumer registration: {}", customerRegistrationRequest);

        customerService.registerCustomer(customerRegistrationRequest);
    }
}
