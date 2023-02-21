package com.lopessystem.notification.config;

import lombok.Getter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
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

    /**
     * Notification queue queue.
     *
     * @return the queue
     */
    @Bean
    public Queue notificationQueue() {
        return new Queue(notificationQueue);
    }

    /**
     * Topic exchange topic exchange.
     *
     * @return the topic exchange
     */
    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(internalExchange);
    }

    /**
     * Internal to notification binding binding.
     *
     * @return the binding
     */
    @Bean
    public Binding internalToNotificationBinding() {
        return BindingBuilder
                .bind(notificationQueue())
                .to(topicExchange())
                .with(internalNotificationRoutingKey);
    }

}
