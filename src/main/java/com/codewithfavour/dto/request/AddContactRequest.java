package com.codewithfavour.dto.request;

import lombok.Data;

@Data
public class AddContactRequest {
    private String contactName;
    private String phoneNumber;
    private String email;
    private String userId;



}
