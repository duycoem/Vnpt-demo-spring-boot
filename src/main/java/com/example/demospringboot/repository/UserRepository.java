package com.example.demospringboot.repository;

import com.example.demospringboot.model.UserDTOModel;
import com.example.demospringboot.model.UserModel;
import com.example.demospringboot.query.UserQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Query(value = UserQuery.GET_ALL_USER)
    List<UserDTOModel> getAll(Pageable pageables);


}
