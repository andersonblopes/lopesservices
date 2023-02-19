package com.lopessystem.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * The interface Notification client.
 */
@FeignClient("notification")
public interface NotificationClient {

    /**
     * Send notification.
     *
     * @param notificationRequest the notification request
     */
    @PostMapping("api/v1/notification")
    void sendNotification(NotificationRequest notificationRequest);
}
