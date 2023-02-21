package com.example.demospringboot.model;


public class UserDTOModel {

    private int userId;

    private String userName;

    private String email;

    private int orderId;

    public UserDTOModel() {
    }

    public UserDTOModel(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public UserDTOModel(int userId, String userName, int orderId) {
        this.userId = userId;
        this.userName = userName;
        this.orderId = orderId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
