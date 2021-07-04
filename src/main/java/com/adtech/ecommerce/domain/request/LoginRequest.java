package com.adtech.ecommerce.domain.request;

import lombok.Data;

@Data
public class LoginRequest {
    String userName;
    String password;
}
