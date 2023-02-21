package com.example.demospringboot.service;

import com.example.demospringboot.model.UserDTOModel;
import com.example.demospringboot.model.UserModel;
import org.springframework.http.HttpStatus;

import java.util.List;


public interface UserService {
    List<UserDTOModel> getAll(int pageNumber, int pageSize);

    UserDTOModel getById(int id);

    void createUser(UserModel user);

    HttpStatus updateUser(int id, UserModel user);

    void deleteUser(int id);
}
