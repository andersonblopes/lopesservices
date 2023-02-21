package com.lopessystem.notification;

import com.lopessystem.amqp.RabbitMQMessageProducer;
import com.lopessystem.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * The type Notification application.
 */
@SpringBootApplication(
        scanBasePackages = {
                "com.lopessystem.notification",
                "com.lopessystem.amqp"
        }
)
@EnableEurekaClient
public class NotificationApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(RabbitMQMessageProducer producer, NotificationConfig config) {
        return args -> {
            producer.publish(new Person("Anderson", 41), config.getInternalExchange(),
                    config.getInternalNotificationRoutingKey());
        };
    }

    record Person(String name, int age) {
    }

}
