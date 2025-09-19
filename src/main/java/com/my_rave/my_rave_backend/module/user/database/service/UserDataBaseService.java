package com.my_rave.my_rave_backend.module.user.database.service;

import com.my_rave.my_rave_backend.module.user.database.model.User;
import com.my_rave.my_rave_backend.module.user.database.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDataBaseService implements IUserDatabaseService{
    private final UserRepository userRepository;

    public UserDataBaseService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(UUID id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public User getUserByCPF(String cpf) {
        return userRepository.findByCpf(cpf).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
