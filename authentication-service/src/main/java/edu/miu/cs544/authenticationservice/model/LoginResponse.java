package edu.miu.cs544.authenticationservice.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginResponse {
    private String jwtToken;
}
