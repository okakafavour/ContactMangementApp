package com.codewithfavour.data.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("User")
public class User {
    private String id;
    private String fullName;
    private String email;
    private String phoneNumber;
    @Getter(AccessLevel.NONE)
    private String password;

    public boolean validPassword(String password){
        return this.password.equals(password);
    }
}
