package com.my_rave.my_rave_backend.module.user.database.service;

import com.my_rave.my_rave_backend.module.user.database.model.User;

import java.util.UUID;

public interface IUserDatabaseService {
    User getUserById(UUID id);
    User getUserByEmail(String email);
    void saveUser(User user);

}
