package com.my_rave.my_rave_backend.module.user.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "interesses")
@Data
@Builder
public class UserInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToMany(mappedBy = "interests")
    private Set<User> users = new HashSet<>();
}
