package com.kasir.sehat.service;

import com.kasir.sehat.dto.SigninRequest;
import com.kasir.sehat.dto.SigninResponse;
import com.kasir.sehat.dto.SignupRequest;
import com.kasir.sehat.dto.SignupResponse;
import com.kasir.sehat.entity.User;
import com.kasir.sehat.repository.UserRepository;
import com.kasir.sehat.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final ModelMapper modelMapper;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtils;

    public SignupResponse registerUser(SignupRequest request) {
        SignupResponse response = new SignupResponse();
        if (userRepository.existsByUsername(request.getUsername())) {
            response.setStatus("Error: Username is already taken!");
            return response;
        }

        User user = modelMapper.map(request, User.class);
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        response.setStatus("User registered successfully!");
        return response;
    }

    public SigninResponse authenticate(SigninRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtUtils.generateToken(userDetails.getUsername());

        SigninResponse response = new SigninResponse();
        response.setToken(token);
        return response;
    }

}
