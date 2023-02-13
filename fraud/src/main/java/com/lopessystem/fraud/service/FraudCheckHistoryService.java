package com.lopessystem.fraud.service;

import com.lopessystem.fraud.model.FraudCheckHistory;
import com.lopessystem.fraud.repository.FraudCheckHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * The type Fraud check history service.
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class FraudCheckHistoryService {

    /**
     * The Fraud check history repository.
     */
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    /**
     * Is fraudulent customer boolean.
     *
     * @param customerId the customer id
     * @return the boolean
     */
    public Boolean isFraudulentCustomer(Long customerId) {

        fraudCheckHistoryRepository.save(FraudCheckHistory
                .builder()
                .customerId(customerId)
                .isFraudster(Boolean.FALSE)
                .build());

        return Boolean.FALSE;
    }
}
