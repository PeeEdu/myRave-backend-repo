package com.my_rave.my_rave_backend.module.user.entity;

import java.time.LocalDate;

public class UserEntity {
    private String name;
    private String login;
    private String cpf;
    private String password;
    private char gender;
    private LocalDate bornDate;
    private Boolean emailConfirm;
    private LocalDate updateAt;
    private LocalDate createdAt;
}