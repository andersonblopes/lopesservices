package com.lopessystem.notification.controller;

import com.lopessystem.clients.notification.NotificationRequest;
import com.lopessystem.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Notification controller.
 */
@AllArgsConstructor
@Slf4j
@RestController
@RequestMapping("api/v1/notification")
public class NotificationController {

    /**
     * The Notification service.
     */
    private final NotificationService notificationService;

    /**
     * Send notification.
     *
     * @param notificationRequest the notification request
     */
    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification... {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
