package com.lopessystem.clients.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Fraud check response.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudCheckResponse {

    /**
     * The Is fraudster.
     */
    private Boolean isFraudster;
}
