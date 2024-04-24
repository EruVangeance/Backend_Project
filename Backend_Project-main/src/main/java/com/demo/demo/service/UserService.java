package com.demo.demo.service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.demo.demo.dto.UserRegistrationDto;
import com.demo.demo.model.User;

public interface UserService extends UserDetailsService {

	User save(UserRegistrationDto registrationDto);

	List<User> getAll();

	boolean sendPasswordResetToken(String email);
    void resetPassword(String token, String newPassword);

    boolean sendPasswordResetLink(String email);
}
