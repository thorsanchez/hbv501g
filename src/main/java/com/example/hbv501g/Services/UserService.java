package com.example.hbv501g.Services;

import com.example.hbv501g.Persistence.Entities.User;

import java.util.List;

public interface UserService {

    User save(User user);

    void delete(User user);

    List<User> findAll();

    User findByUsername(String username);

    User findByEmail(String email);

    User login(User user);

    //
    void setLoggedIn(User user, boolean status);
}
