package com.lopessystem.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * The interface Fraud client.
 */
@FeignClient("fraud")
public interface FraudClient {

    /**
     * Is fraudster fraud check response.
     *
     * @param customerId the customer id
     * @return the fraud check response
     */
    @GetMapping(path = "api/v1/fraud-check/{customerId}")
    FraudCheckResponse isFraudster(
            @PathVariable("customerId") Long customerId);

}
