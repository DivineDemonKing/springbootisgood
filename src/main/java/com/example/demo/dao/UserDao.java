package com.example.demo.dao;



import com.example.demo.model.User;

import java.util.List;
public interface UserDao {
   void add(User user);
   void deleteById (long id);
   void update(User user);
   List<User> listUsers();
}
