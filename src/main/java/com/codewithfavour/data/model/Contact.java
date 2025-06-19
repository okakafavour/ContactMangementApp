package com.codewithfavour.data.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Contact")
public class Contact {
    private String id;
    private String contactName;
    private String email;
    private String phoneNumber;
    private String userId;


}
