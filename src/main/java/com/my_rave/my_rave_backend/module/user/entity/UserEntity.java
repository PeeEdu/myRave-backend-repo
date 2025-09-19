package com.my_rave.my_rave_backend.module.user.entity;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class UserEntity {
    private String name;
    private String login;
    private String email;
    private String cpf;
    private String password;
    private char gender;
    private LocalDate bornDate;
    private Boolean emailConfirm;
    private LocalDate updateAt;
    private LocalDate createdAt;

}