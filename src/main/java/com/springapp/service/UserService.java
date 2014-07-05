package com.springapp.service;

import com.springapp.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    User addUser(User user);

    void delete(long id);

   // UserDetails getByLogin(String login);

    User editUser(User user);

    List<User> getAll();
}
