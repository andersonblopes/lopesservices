package com.lopessystem.clients.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The type Fraud check response.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class FraudCheckResponse {

    /**
     * The Is fraudster.
     */
    private Boolean isFraudster;
}
