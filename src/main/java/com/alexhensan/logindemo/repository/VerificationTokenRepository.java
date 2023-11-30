package com.alexhensan.logindemo.repository;

import com.alexhensan.logindemo.registration.token.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
}
