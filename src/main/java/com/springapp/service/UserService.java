package com.springapp.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.springapp.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserService {
    User addUser(User user) throws MySQLIntegrityConstraintViolationException;

    void delete(long id);

    //User getByLogin(String login);

    User editUser(User user);

    List<User> getAll();
}
