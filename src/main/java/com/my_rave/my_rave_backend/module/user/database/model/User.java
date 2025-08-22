package com.my_rave.my_rave_backend.module.user.database.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "users")
@Table(name = "users")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private UUID id;

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
