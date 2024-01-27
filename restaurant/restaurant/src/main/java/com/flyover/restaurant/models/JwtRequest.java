package com.flyover.restaurant.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtRequest {
    private String mobileNumber;
    private String email;
    private String password;
}
