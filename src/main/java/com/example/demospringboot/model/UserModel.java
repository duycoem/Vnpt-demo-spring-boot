package com.example.demospringboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = "data_user")
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_name")
    @NotEmpty(message = "Không được bỏ trống userName")
    private String userName;

    @NotEmpty(message = "Không được bỏ trống password")
    @Length(min = 8, message = "Password phải từ 8 kí tự trở lên")
    private String password;

    @Email(message = "Email không đúng định dạng")
    private String email;

}
