package com.codewithfavour.services;

import com.codewithfavour.data.model.Contact;
import com.codewithfavour.data.model.User;
import com.codewithfavour.data.repository.ContactRepository;
import com.codewithfavour.data.repository.UserRepository;
import com.codewithfavour.dto.request.AddContactRequest;
import com.codewithfavour.dto.request.UpdateContactRequest;
import com.codewithfavour.dto.request.UserLoginRequest;
import com.codewithfavour.dto.request.UserRegisterRequest;
import com.codewithfavour.dto.response.AddContactResponse;
import com.codewithfavour.dto.response.UpdateContactResponse;
import com.codewithfavour.dto.response.UserLoginResponse;
import com.codewithfavour.dto.response.UserRegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ContactServiceImplTest {

    UserRegisterRequest userRegisterRequest;
    UserLoginRequest userLoginRequest;

    @Autowired
     UserRepository userRepository;

    @Autowired
    private ContactServiceImpl contactService;
    @Autowired
    private ContactRepository contactRepository;

    @BeforeEach
    void setUp(){
        userRepository.deleteAll();
    }

    @Test
    public void testToRegister(){
        UserRegisterRequest request = new UserRegisterRequest();
        request.setFullName("john Doe");
        request.setEmail("john@doe.com");
        request.setPassword("password");

        contactService.register(request);
        assertEquals(1, userRepository.count());

    }

    @Test
    public void testToLogin(){

            UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
            userRegisterRequest.setFullName("Fave");
            userRegisterRequest.setEmail("fave@codewithfavour.com");
            userRegisterRequest.setPassword("123456");
            userRegisterRequest.setPhoneNumber("01234567890");

            UserRegisterResponse registerResponse = contactService.register(userRegisterRequest);
            assertEquals("Registered successfully", registerResponse.getMessage());

            UserLoginRequest userLoginRequest = new UserLoginRequest();
            userLoginRequest.setPhoneNumber("01234567890");
            userLoginRequest.setEmail("fave@codewithfavour.com");
            userLoginRequest.setPassword("123456");

            UserLoginResponse userLoginResponse = contactService.login(userLoginRequest);
            assertEquals("Login successfully", userLoginResponse.getMessage());
    }

    @Test
    public void testToAddAContact(){
        User user = new User();
        user.setFullName("John");
        user.setEmail("john@codewithfavour.com");
        user.setPassword("123456");
        user.setPhoneNumber("01234567890");
        User user1 = userRepository.save(user);

        AddContactRequest request = new AddContactRequest();
        request.setContactName("bamidele");
        request.setEmail("bamidele@codewithfavour.com");
        request.setPhoneNumber("01234567890");
        request.setUserId(user1.getId());

        AddContactResponse addContactResponse = contactService.addContact(request);
        assertEquals("contact added successfully", addContactResponse.getMessage());
    }

    @Test
    public void testToUpdateAContact(){
        User user = new User();
        user.setFullName("John");
        user.setEmail("john@codewithfavour.com");
        user.setPassword("123456");
        user.setPhoneNumber("01234567890");
        User user1 = userRepository.save(user);

        Contact contact = new Contact();
        contact.setId(user1.getId());
        contact.setContactName("bamidele");
        contact.setEmail("bam@gmail.com");
        contact.setPhoneNumber("01234567890");
        Contact savedContact = contactRepository.save(contact);

        UpdateContactRequest request = new UpdateContactRequest();
        request.setContactId(savedContact.getId());
        request.setContactName("samuel");
        request.setEmail("samuel@codewithfavour.com");
        request.setPhoneNumber("09012345767");
        UpdateContactResponse updateContactResponse = contactService.updateContact(request);
        assertEquals("Contact updated", updateContactResponse.getMessage());
    }


}