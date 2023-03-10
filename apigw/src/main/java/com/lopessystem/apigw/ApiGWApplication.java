package com.lopessystem.apigw;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * The type Api gw application.
 */
@EnableEurekaClient
@SpringBootApplication
public class ApiGWApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        SpringApplication.run(ApiGWApplication.class, args);
    }
}
