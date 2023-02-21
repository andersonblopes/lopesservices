package com.lopessystem.amqp;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

/**
 * The type Rabbit mq message producer.
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class RabbitMQMessageProducer {

    /**
     * The Amqp template.
     */
    private final AmqpTemplate amqpTemplate;

    /**
     * Publish.
     *
     * @param payload    the payload
     * @param exchange   the exchange
     * @param routingKey the routing key
     */
    public void publish(Object payload, String exchange, String routingKey) {
        log.info("Publishing to: {} using routingkey {}, Payload: {}", exchange, routingKey, payload);
        amqpTemplate.convertAndSend(exchange, routingKey, payload);
        log.info("Published to: {} using routingkey {}, Payload: {}", exchange, routingKey, payload);

    }
}
