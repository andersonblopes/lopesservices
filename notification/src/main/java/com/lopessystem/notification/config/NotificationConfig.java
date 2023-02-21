package com.lopessystem.notification.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * The type Notification config.
 */
@Getter
@Configuration
public class NotificationConfig {

    /**
     * The Internal exchange.
     */
    @Value("${rabbitmq.exchanges.internal}")
    private String internalExchange;

    /**
     * The Notification queue.
     */
    @Value("${rabbitmq.queue.notification}")
    private String notificationQueue;

    /**
     * The Internal notification routing key.
     */
    @Value("${rabbitmq.routing-keys.internal-notification}")
    private String internalNotificationRoutingKey;

}
