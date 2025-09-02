package com.app.rest_api.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
}
