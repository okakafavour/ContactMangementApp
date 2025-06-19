package com.codewithfavour.dto.request;

import lombok.Data;

@Data
public class DeleteContactRequest {
    private String userId;
    private String contactName;
    private String phoneNumber;

}
