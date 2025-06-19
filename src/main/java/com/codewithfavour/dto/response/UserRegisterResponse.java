package com.codewithfavour.dto.response;

import lombok.Data;

@Data

public class UserRegisterResponse {
    private String id;
    private String fullName;
    private String phoneNumber;
    private String email;
    private String message;
}
