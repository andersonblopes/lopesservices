package com.lopessystem.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Notification request.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationRequest {

    /**
     * The To customer id.
     */
    private Long toCustomerId;

    /**
     * The To customer name.
     */
    private String toCustomerName;

    /**
     * The Message.
     */
    private String message;
}
