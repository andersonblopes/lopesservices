package com.lopessystem.fraud.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.OffsetDateTime;

/**
 * The type Fraud check history.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {

    /**
     * The Id.
     */
    @Id
    @SequenceGenerator(
            name = "fraud_id_sequence",
            sequenceName = "fraud_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_sequence"
    )
    private Long id;

    /**
     * The Customer id.
     */
    private Long customerId;

    /**
     * The Is fraudster.
     */
    private Boolean isFraudster;

    /**
     * The Created at.
     */
    @CreationTimestamp
    private OffsetDateTime createdAt;
}
