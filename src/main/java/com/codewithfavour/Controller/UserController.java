package com.codewithfavour.Controller;

import com.codewithfavour.dto.request.UserLoginRequest;
import com.codewithfavour.dto.request.UserRegisterRequest;
import com.codewithfavour.dto.response.UserLoginResponse;
import com.codewithfavour.dto.response.UserRegisterResponse;
import com.codewithfavour.services.ContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    ContactServiceImpl contactService;

    @PostMapping("/register")
    public ResponseEntity<UserRegisterResponse> registerUser(@RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(contactService.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<UserLoginResponse> loginUser(@RequestBody UserLoginRequest request) {
        return ResponseEntity.ok(contactService.login(request));
    }


}
