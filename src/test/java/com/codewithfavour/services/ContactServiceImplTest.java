package com.codewithfavour.services;

import com.codewithfavour.data.model.Contact;
import com.codewithfavour.data.model.User;
import com.codewithfavour.data.repository.UserRepository;
import com.codewithfavour.dto.request.UserRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ContactServiceImplTest {

    UserRegisterRequest userRegisterRequest;

    @Autowired
     UserRepository userRepository;

    @Autowired
    private ContactServiceImpl contactService;

    @Test
    public void testToRegister(){
        UserRegisterRequest request = new UserRegisterRequest();
        request.setFullName("john Doe");
        request.setEmail("john@doe.com");
        request.setPassword("password");

        contactService.register(request);
        assertEquals(1, userRepository.count());

    }

}