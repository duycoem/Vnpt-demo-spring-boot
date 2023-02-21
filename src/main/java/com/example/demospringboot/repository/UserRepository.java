package com.example.demospringboot.repository;

import com.example.demospringboot.model.UserDTOModel;
import com.example.demospringboot.model.UserModel;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>, PagingAndSortingRepository<UserModel, Integer> {
    
    @Query(name = "get_all_user_dto", nativeQuery = true)
    List<UserDTOModel> getAll(Pageable pageable);

    @Query(name = "get_user_dto_by_id", nativeQuery = true)
    UserDTOModel getById(@Param("id") int id);
}
