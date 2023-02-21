package com.example.demospringboot.service;

import com.example.demospringboot.model.UserDTOModel;
import com.example.demospringboot.model.UserModel;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.util.List;


public interface UserService {
    @Description(value = "Lấy danh sách user dto theo phân trang")
    List<UserDTOModel> getAll(Pageable pageable);

    @Description(value = "Lấy thông tin user theo id")
    UserModel getById(int id);
    
    @Description(value = "Thêm mới user")
    void createUser(UserModel user);


    @Description(value = "Cập nhật user")
    Boolean updateUser(int id, UserModel user);

    @Description(value = "Xoá user")
    void deleteUser(int id);
}
