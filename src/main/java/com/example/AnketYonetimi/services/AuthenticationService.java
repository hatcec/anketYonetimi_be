package com.example.AnketYonetimi.services;


import com.example.AnketYonetimi.business.dto.AuthenticationResponse;
import com.example.AnketYonetimi.entities.User;

public interface AuthenticationService {
    AuthenticationResponse createCustomer(AuthenticationResponse authenticationResponse);
    AuthenticationResponse login(AuthenticationResponse authenticationResponse );
    boolean hasCustomerWithEmail(String email);
    AuthenticationResponse refreshToken(AuthenticationResponse refreshTokenReqiest);
    AuthenticationResponse getAllUsers();
    AuthenticationResponse getUsersById(Integer id);
    AuthenticationResponse deleteUser(Integer userId);
    AuthenticationResponse updateUser(Integer userId, User updatedUser);
    AuthenticationResponse getMyInfo(String email);
}
