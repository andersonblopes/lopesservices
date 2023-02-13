package com.lopessystem.fraud.controller;

import com.lopessystem.clients.FraudCheckResponse;
import com.lopessystem.fraud.service.FraudCheckHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The type Fraud check history controller.
 */
@Slf4j
@RequiredArgsConstructor
public class FraudCheckHistoryController {

    /**
     * The Fraud check history service.
     */
    private final FraudCheckHistoryService fraudCheckHistoryService;

    /**
     * Is fraudster fraud check history response.
     *
     * @param customerId the customer id
     * @return the fraud check history response
     */
    @GetMapping("/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Long customerId) {

        log.debug("isFraudster");
        log.debug("customerId: {}", customerId);

        Boolean isFraudulentCustomer = fraudCheckHistoryService.isFraudulentCustomer(customerId);

        return FraudCheckResponse.builder().isFraudster(isFraudulentCustomer).build();
    }
}
