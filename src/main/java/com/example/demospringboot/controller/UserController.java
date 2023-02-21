package com.example.demospringboot.controller;

import com.example.demospringboot.model.UserDTOModel;
import com.example.demospringboot.model.UserModel;
import com.example.demospringboot.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<?> getAllUser(@RequestParam(required = false, defaultValue = "1") int pageNumber,
                                        @RequestParam(required = false, defaultValue = "10") int pageSize) {

        try {
            List<UserDTOModel> users = userService.getAll(pageNumber, pageSize);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
        UserDTOModel user = userService.getById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found user");
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserModel user) {
        try {
            userService.createUser(user);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserModel user) {
        try {
            HttpStatus updateStatus = userService.updateUser(id, user);
            if (updateStatus == HttpStatus.OK) {
                return ResponseEntity.ok("Success");
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found user");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error");
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("Success");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found user");
        }
    }
}
