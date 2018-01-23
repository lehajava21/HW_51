package com.leha.model;

import lombok.Data;

@Data
public class RegistrationResponse {
    private String sessionId;
    private UserWeb user;
}
