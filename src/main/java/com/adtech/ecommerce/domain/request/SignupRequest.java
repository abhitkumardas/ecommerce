package com.adtech.ecommerce.domain.request;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class SignupRequest {
    String userName;
    String password;
    String email;
    Set<String> roles;

}
