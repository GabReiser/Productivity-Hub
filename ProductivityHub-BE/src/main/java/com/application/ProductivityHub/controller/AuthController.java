package com.application.ProductivityHub.controller;

import com.application.ProductivityHub.model.User;
import com.application.ProductivityHub.repository.UserRepository;
import com.application.ProductivityHub.security.JwtRequest;
import com.application.ProductivityHub.security.JwtRequestFilter;
import com.application.ProductivityHub.security.JwtResponse;
import com.application.ProductivityHub.security.JwtTokenUtil;
import com.application.ProductivityHub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Error: Email is already in use!");
        }

        // Codifique a senha antes de salvar
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        System.out.println("User registered successfully!" + "\n\n" +
                "E-mail: " + user.getEmail() +
                "\n" + "Username: " + user.getUsername());
        return ResponseEntity.ok("User registered successfully!" + "\n\n" +
                "E-mail: " + user.getEmail() +
                "\n" + "Username: " + user.getUsername());
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
            System.out.println("Auth: " + authentication);
        } catch (AuthenticationException e) {
            System.out.println(e.getMessage());
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new JwtResponse(token));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
