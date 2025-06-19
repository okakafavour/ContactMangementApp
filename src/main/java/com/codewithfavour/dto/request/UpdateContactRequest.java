package com.codewithfavour.dto.request;

import lombok.Data;

@Data
public class UpdateContactRequest {
    private String contactName;
    private String email;
    private String phoneNumber;
    private String contactId;


}
