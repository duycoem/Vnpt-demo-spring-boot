package com.example.demospringboot.model;

import javax.persistence.*;

@NamedNativeQuery(
        name = "get_all_user_dto",
        query = "select du.id as userId, du.user_name as userName, dor.id as orderId\n" +
                "from data_user du join data_order dor on du.id = dor.user_id",
        resultSetMapping = "get_all_user_dto"
)
@NamedNativeQuery(
        name = "get_user_dto_by_id",
        query = "select id, user_name as userName, email from data_user where id = :id",
        resultSetMapping = "get_user_dto_by_id"
)
@SqlResultSetMapping(
        name = "get_all_user_dto",
        classes = @ConstructorResult(
                targetClass = UserDTOModel.class,
                columns = {
                        @ColumnResult(name = "userId", type = Integer.class),
                        @ColumnResult(name = "userName", type = String.class),
                        @ColumnResult(name = "orderId", type = Integer.class),
                }
        )
)
@SqlResultSetMapping(
        name = "get_user_dto_by_id",
        classes = @ConstructorResult(
                targetClass = UserDTOModel.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "userName", type = String.class),
                       
                }
        )
)
@Entity
@Table(name = "data_user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    private String password;

    private String email;

    public UserModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
