package com.my_rave.my_rave_backend.module.user.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "usuarios",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "cpf")
        })
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String password;

    private Character gender;

    private LocalDate bornDate;

    private Boolean emailConfirm = false;

    private LocalDate createdAt = LocalDate.now();

    private LocalDate updatedAt = LocalDate.now();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "interest_id")
    )
    private Set<UserInterest> interests = new HashSet<>();

    public void addInterest(UserInterest interest) {
        if (this.interests == null) {
            this.interests = new HashSet<>();
        }
        if (this.interests.size() >= 5) {
            throw new IllegalArgumentException("Um usuário só pode ter até 5 interesses.");
        }
        this.interests.add(interest);
        interest.getUsers().add(this);
    }

    public void removeInterest(UserInterest interest) {
        if (this.interests != null && this.interests.contains(interest)) {
            this.interests.remove(interest);
            interest.getUsers().remove(this);
        }
    }
}
