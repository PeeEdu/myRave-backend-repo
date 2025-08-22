package com.my_rave.my_rave_backend.module.user.database.repository;

import com.my_rave.my_rave_backend.module.user.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    @Query("SELECT u FROM users u WHERE u.login = :login")
    Optional<User> findByLogin(String login);
}
