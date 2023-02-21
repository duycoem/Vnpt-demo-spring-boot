package com.example.demospringboot.query;

public class UserQuery {
    public static final String GET_ALL_USER = "select new com.example.demospringboot.model.UserDTOModel(" +
            "um.id as userId, um.userName, um.email)" +
            "from UserModel um";
}
