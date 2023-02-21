package com.lopessystem.notification.rabbitmq;

import com.lopessystem.clients.notification.NotificationRequest;
import com.lopessystem.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * The type Notification consumer.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class NotificationConsumer {

    /**
     * The Notification service.
     */
    private final NotificationService notificationService;

    /**
     * Consumer.
     *
     * @param notificationRequest the notification request
     */
    @RabbitListener(queues = "${rabbitmq.queue.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consume {} from queue", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
