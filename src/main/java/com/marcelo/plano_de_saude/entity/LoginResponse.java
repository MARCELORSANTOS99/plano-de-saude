package com.marcelo.plano_de_saude.entity;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private long expiresIn;

    public String getToken() {
        return token;
    }

 // Getters and setters...
}
