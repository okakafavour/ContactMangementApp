package com.codewithfavour.dto.request;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String phoneNumber;
    private String password;
}
