package com.my_rave.my_rave_backend.login.controller;

import com.my_rave.my_rave_backend.config.JwtUtil;
import com.my_rave.my_rave_backend.module.user.database.model.User;
import com.my_rave.my_rave_backend.module.user.database.model.UserDetailsImpl;
import com.my_rave.my_rave_backend.module.user.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String login = credentials.get("login");
        String password = credentials.get("password");

        if (login == null || password == null) {
            return ResponseEntity.badRequest().body("Login e senha são obrigatórios");
        }

        System.out.println("Login: " + login);
        System.out.println("Password: " + password);

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(login, password));

        Optional<User> userOptional = userRepository.findByLogin(login);
        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));

        String token = jwtUtil.generateToken(new UserDetailsImpl(user));

        return ResponseEntity.ok(Map.of("token", token));
    }
}
