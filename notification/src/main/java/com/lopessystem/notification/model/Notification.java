package com.lopessystem.notification.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

/**
 * The type Notification.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Notification {

    /**
     * The Notification id.
     */
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )
    private Long notificationId;

    /**
     * The To customer id.
     */
    private Long toCustomerId;

    /**
     * The To customer email.
     */
    private String toCustomerEmail;

    /**
     * The Sender.
     */
    private String sender;

    /**
     * The Message.
     */
    private String message;

    /**
     * The Sent at.
     */
    private LocalDateTime sentAt;
}
