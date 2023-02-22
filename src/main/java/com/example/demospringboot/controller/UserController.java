package com.example.demospringboot.controller;

import com.example.demospringboot.dto.UserModelDTO;
import com.example.demospringboot.model.UserModel;
import com.example.demospringboot.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<UserModelDTO> getAllUser(@RequestParam(required = false, defaultValue = "1") Integer pageNumber,
                                         @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
        return userService.getAll(pageable);


    }

    @GetMapping("/user/{id}")
    public UserModel getUserById(@PathVariable Integer id) {
        return userService.getById(id);

    }

    @PostMapping("/user")
    public void createUser(@RequestBody @Valid UserModel user) {
        userService.createUser(user);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody @Valid UserModel user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }
}
