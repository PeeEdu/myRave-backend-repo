package com.my_rave.my_rave_backend.module.user.database.service;

import com.my_rave.my_rave_backend.module.user.database.model.User;
import com.my_rave.my_rave_backend.module.user.database.model.UserDetailsImpl;
import com.my_rave.my_rave_backend.module.user.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Buscando usuário com login: " + username);
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        System.out.println("Usuário encontrado - Login: " + user.getLogin() + ", Password: " + user.getPassword() + ", Email Confirm: " + user.getEmailConfirm());
        return new UserDetailsImpl(user);
    }
}