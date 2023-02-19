package com.lopessystem.notification.service;

import com.lopessystem.clients.notification.NotificationRequest;
import com.lopessystem.notification.model.Notification;
import com.lopessystem.notification.repository.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * The type Notification service.
 */
@Service
@AllArgsConstructor
public class NotificationService {

    /**
     * The Notification repository.
     */
    private final NotificationRepository notificationRepository;

    /**
     * Send.
     *
     * @param notificationRequest the notification request
     */
    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.getToCustomerId())
                        .toCustomerEmail(notificationRequest.getToCustomerName())
                        .sender("lopesservice")
                        .message(notificationRequest.getMessage())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}
