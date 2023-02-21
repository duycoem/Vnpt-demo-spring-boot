package com.example.demospringboot.controller;

import com.example.demospringboot.model.UserDTOModel;
import com.example.demospringboot.model.UserModel;
import com.example.demospringboot.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<UserDTOModel> getAllUser(@RequestParam(required = false, defaultValue = "1") int pageNumber,
                                         @RequestParam(required = false, defaultValue = "10") int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        List<UserDTOModel> users = userService.getAll(pageable);
        return users;

    }

    @GetMapping("/user/{id}")
    public UserModel getUserById(@PathVariable int id) {
        UserModel user = userService.getById(id);
        return user;
    }

    @PostMapping("/user")
    public void createUser(@RequestBody @Valid UserModel user) {
        userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public Boolean updateUser(@PathVariable int id, @RequestBody @Valid UserModel user) {
        Boolean isUpdateSuccess = userService.updateUser(id, user);
        return isUpdateSuccess;

    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
