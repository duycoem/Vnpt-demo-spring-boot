package com.example.demospringboot.service;

import com.example.demospringboot.dto.UserModelDTO;
import com.example.demospringboot.model.UserModel;
import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {
    @Description(value = "Lấy danh sách user dto theo phân trang")
    List<UserModelDTO> getAll(Pageable pageable);

    @Description(value = "Lấy thông tin user theo id")
    UserModel getById(Integer id);

    @Description(value = "Thêm mới user")
    void createUser(UserModel user);

    @Description(value = "Cập nhật user")
    void updateUser(Integer id, UserModel user);

    @Description(value = "Xoá user")
    void deleteUser(Integer id);
}
