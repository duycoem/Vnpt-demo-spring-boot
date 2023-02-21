package com.example.demospringboot.service;

import com.example.demospringboot.model.UserDTOModel;
import com.example.demospringboot.model.UserModel;
import com.example.demospringboot.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTOModel> getAll(Pageable pageable) {
        return userRepository.getAll(pageable);

    }

    @Override
    public UserModel getById(int id) {
        UserModel user = userRepository.findById(id).orElse(null);
        return user;
    }

    @Override
    public void createUser(UserModel user) {
        userRepository.save(user);
    }

    @Override
    public Boolean updateUser(int id, UserModel userInput) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            user.setUserName(userInput.getUserName());
            user.setPassword(userInput.getPassword());
            user.setEmail(userInput.getEmail());
            userRepository.save(user);
            return true;
        }
        return false;

    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
