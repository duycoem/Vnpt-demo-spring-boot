package com.example.demospringboot.service;

import com.example.demospringboot.dto.UserModelDTO;
import com.example.demospringboot.model.UserModel;
import com.example.demospringboot.repository.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModelDTO> getAll(Pageable pageable) {
        return userRepository.getAll(pageable);

    }

    @Override
    public UserModel getById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void createUser(UserModel user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Integer id, UserModel userInput) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            user.setUserName(userInput.getUserName());
            user.setPassword(userInput.getPassword());
            user.setEmail(userInput.getEmail());
            userRepository.save(user);
            
        }
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
