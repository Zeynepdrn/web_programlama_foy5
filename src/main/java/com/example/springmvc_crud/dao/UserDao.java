package com.example.springmvc_crud.dao;

import com.example.springmvc_crud.entity.User;
import java.util.List;

public interface UserDao {
    void save(User user);

    void update(User user);

    void delete(Long id);

    List<User> findAll();

    User findById(Long id);
}
