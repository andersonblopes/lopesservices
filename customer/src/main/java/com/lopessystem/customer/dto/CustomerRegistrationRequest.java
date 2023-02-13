package com.lopessystem.customer.dto;

import lombok.Data;

/**
 * The type Customer registration request.
 */
@Data
public class CustomerRegistrationRequest {

    /**
     * The First name.
     */
    private String firstName;
    /**
     * The Last name.
     */
    private String lastName;
    /**
     * The Email.
     */
    private String email;
}
