package com.example.demospringboot.service;

import com.example.demospringboot.model.UserDTOModel;
import com.example.demospringboot.model.UserModel;
import com.example.demospringboot.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public List<UserDTOModel> getAll(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);

        try {
            return userRepository.getAll(pageable);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public UserDTOModel getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public void createUser(UserModel user) {
        userRepository.save(user);
    }

    @Override
    public HttpStatus updateUser(int id, UserModel userInput) {
        Optional<UserModel> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserModel user = userOptional.get();
            user.setUserName(userInput.getUserName());
            user.setPassword(userInput.getPassword());
            user.setEmail(userInput.getEmail());
            userRepository.save(user);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;

    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
