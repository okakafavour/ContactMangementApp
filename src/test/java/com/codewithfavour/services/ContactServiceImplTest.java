package com.codewithfavour.services;

import com.codewithfavour.data.model.Contact;
import com.codewithfavour.data.model.User;
import com.codewithfavour.data.repository.UserRepository;
import com.codewithfavour.dto.request.UserLoginRequest;
import com.codewithfavour.dto.request.UserRegisterRequest;
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

}