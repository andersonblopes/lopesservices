package com.lopessystem.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

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

}
