package com.codewithfavour.dto.response;

import lombok.Data;

@Data
public class UserLoginResponse {
    private String id;
    private String phoneNumber;
    private String message;
}
