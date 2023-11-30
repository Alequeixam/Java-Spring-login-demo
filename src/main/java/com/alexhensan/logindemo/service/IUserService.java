package com.alexhensan.logindemo.service;

import com.alexhensan.logindemo.model.User;
import com.alexhensan.logindemo.registration.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);

    void saveUserVerifcationToken(String token, User user);
}
