package com.lopessystem.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Fraud check history response.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudCheckHistoryResponse {

    /**
     * The Is fraudster.
     */
    private Boolean isFraudster;
}
