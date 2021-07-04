package com.adtech.ecommerce.domain.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    String token;
    String id;
    String userName;
    String email;
    List<String> roles;
}
