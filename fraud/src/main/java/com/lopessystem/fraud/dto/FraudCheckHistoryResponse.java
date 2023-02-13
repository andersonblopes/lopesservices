package com.lopessystem.fraud.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * The type Fraud check history response.
 */
@Getter
@Builder
public class FraudCheckHistoryResponse {

    /**
     * The Is fraudster.
     */
    private Boolean isFraudster;
}
