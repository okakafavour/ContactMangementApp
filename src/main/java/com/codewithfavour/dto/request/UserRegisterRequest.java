package com.codewithfavour.dto.request;

import lombok.Data;

@Data
public class UserRegisterRequest {
    private String id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;
}
