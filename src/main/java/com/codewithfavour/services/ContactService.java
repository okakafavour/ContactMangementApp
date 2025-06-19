package com.codewithfavour.services;


import com.codewithfavour.dto.request.*;
import com.codewithfavour.dto.response.AddContactResponse;
import com.codewithfavour.dto.response.UserLoginResponse;
import com.codewithfavour.dto.response.UserRegisterResponse;
import com.codewithfavour.dto.response.UpdateContactResponse;
import org.springframework.stereotype.Service;


@Service
public interface ContactService {
    UserRegisterResponse register(UserRegisterRequest userRegisterRequest);
    UserLoginResponse login(UserLoginRequest userLoginRequest);
    AddContactResponse addContact(AddContactRequest addContactRequest);
    String deleteContact(DeleteContactRequest deleteContactRequest);
    UpdateContactResponse updateContact(UpdateContactRequest updateContactRequest);
}
