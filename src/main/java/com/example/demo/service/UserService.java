package com.example.demo.service;

import com.example.demo.model.User;


import java.util.List;
public interface UserService {
    void add(User user);
    void deleteById (long id);
    void update( User user);
    List<User> listUsers();
}
