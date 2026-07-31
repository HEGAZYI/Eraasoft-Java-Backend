package com.item.service;

import com.item.model.User;

public interface UserService {

    boolean register(User user);

    User login(String usernameOrEmail, String password);

    User findByUsername(String username);

    User findByEmail(String email);

    User findById(Long id);

    boolean updatePassword(Long userId, String newPasswordHash);

    boolean deleteAccount(Long userId);
}
