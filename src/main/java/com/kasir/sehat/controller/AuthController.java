package com.kasir.sehat.controller;

import com.kasir.sehat.dto.SigninRequest;
import com.kasir.sehat.dto.SigninResponse;
import com.kasir.sehat.dto.SignupRequest;
import com.kasir.sehat.dto.SignupResponse;
import com.kasir.sehat.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<SigninResponse> authenticate(@RequestBody SigninRequest request) {
        SigninResponse response = userService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> registerUser(@RequestBody SignupRequest request) {
        SignupResponse response = userService.registerUser(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

