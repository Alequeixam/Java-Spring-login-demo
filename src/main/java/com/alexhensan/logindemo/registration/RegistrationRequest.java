package com.alexhensan.logindemo.registration;


public record RegistrationRequest(String firstName,
        String lastName,
        String email,
        String password,
        String role) {
}
