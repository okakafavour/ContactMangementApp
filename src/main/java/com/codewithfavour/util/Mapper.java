package com.codewithfavour.util;

import com.codewithfavour.data.model.Contact;
import com.codewithfavour.data.model.User;
import com.codewithfavour.data.repository.ContactRepository;
import com.codewithfavour.data.repository.UserRepository;
import com.codewithfavour.dto.request.AddContactRequest;
import com.codewithfavour.dto.request.DeleteContactRequest;
import com.codewithfavour.dto.request.UserLoginRequest;
import com.codewithfavour.dto.request.UserRegisterRequest;
import com.codewithfavour.dto.response.AddContactResponse;
import com.codewithfavour.dto.response.UpdateContactResponse;
import com.codewithfavour.dto.response.UserLoginResponse;
import com.codewithfavour.dto.response.UserRegisterResponse;
import com.codewithfavour.exception.InvalidUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    public User mapToRequest(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setFullName(userRegisterRequest.getFullName());
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(userRegisterRequest.getPassword());
        user.setPhoneNumber(userRegisterRequest.getPhoneNumber());
        return user;
    }

    public UserRegisterResponse mapToRegisterResponse(User user) {
        UserRegisterResponse userRegisterResponse = new UserRegisterResponse();
        userRegisterResponse.setFullName(user.getFullName());
        userRegisterResponse.setEmail(user.getEmail());
        userRegisterResponse.setPhoneNumber(user.getPhoneNumber());
        userRegisterResponse.setId(user.getId());
        userRegisterResponse.setMessage("Registered successfully");
        return userRegisterResponse;
    }

    public UserLoginResponse mapToLogin(UserLoginRequest request){
        UserLoginResponse userLoginResponse = new UserLoginResponse();
        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) throw new RuntimeException("User not found");

        if (!user.validPassword(request.getPassword())) throw new RuntimeException("Invalid password");


        userLoginResponse.setMessage("Login successfully");
        return userLoginResponse;
    }


    public Contact addContact(AddContactRequest addContactRequest) {
        User user = userRepository.findById(addContactRequest.getUserId())
                .orElseThrow(() -> new InvalidUserException("User not found"));        Contact contact = new Contact();

        Contact contacts = new Contact();
        contact.setUserId(user.getId());
        contacts.setContactName(addContactRequest.getContactName());
        contacts.setEmail(addContactRequest.getEmail());
        contacts.setPhoneNumber(addContactRequest.getPhoneNumber());
        return contactRepository.save(contacts);
    }


    public AddContactResponse mapToAddContact(Contact contact) {
        AddContactResponse response = new AddContactResponse();
        response.setId(contact.getId());
        response.setMessage("Add contact successful");
        return response;
    }


    public Contact mapToDeleteContact(DeleteContactRequest request) {
        String contactName = request.getContactName();
        String phoneNumber = request.getPhoneNumber();

        if ((contactName == null || contactName.trim().isEmpty()) &&
                (phoneNumber == null || phoneNumber.trim().isEmpty())) {
            throw new IllegalArgumentException("Either contact name or phone number must be provided");
        }

        Contact contact = new Contact();
        contact.setContactName(contact.getContactName());
        contact.setPhoneNumber(phoneNumber);
        return contact;
    }

    public UpdateContactResponse mapToUpdateContactResponse(Contact response){
        UpdateContactResponse updateContactResponse = new UpdateContactResponse();
        updateContactResponse.setMessage("Contact updated");
        return updateContactResponse;
    }

}