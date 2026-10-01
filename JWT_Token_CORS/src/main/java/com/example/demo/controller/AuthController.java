package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.model.AppUser;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

private final AuthenticationManager authenticationManager;

private final UserRepository userRepository;

private final PasswordEncoder passwordEncoder;

private final JwtService jwtService;

public AuthController(
AuthenticationManager authenticationManager,
UserRepository userRepository,
PasswordEncoder passwordEncoder,
JwtService jwtService) {

this.authenticationManager =
authenticationManager;

this.userRepository =
userRepository;

this.passwordEncoder =
passwordEncoder;

this.jwtService =
jwtService;
}

@PostMapping("/register")
public ResponseEntity<String> register(
@RequestBody LoginRequest request) {

if (userRepository
.findByUsername(request.getUsername())
.isPresent()) {

return ResponseEntity
.badRequest()
.body("Username already exists");
}

AppUser user = new AppUser();

user.setUsername(
request.getUsername());

user.setPassword(
passwordEncoder.encode(
request.getPassword()));

user.setRole("ROLE_USER");

userRepository.save(user);

return ResponseEntity.ok(
"User registered successfully");
}

@PostMapping("/register-admin")
public ResponseEntity<String> registerAdmin(
@RequestBody LoginRequest request) {

AppUser user = new AppUser();

user.setUsername(
request.getUsername());

user.setPassword(
passwordEncoder.encode(
request.getPassword()));

user.setRole("ROLE_ADMIN");

userRepository.save(user);

return ResponseEntity.ok(
"Admin registered successfully");
}

@PostMapping("/login")
public ResponseEntity<LoginResponse> login(
@RequestBody LoginRequest request) {

org.springframework.security.core.Authentication authentication =
authenticationManager.authenticate(
new UsernamePasswordAuthenticationToken(
request.getUsername(),
request.getPassword()
)
);

UserDetails userDetails =
(UserDetails) authentication.getPrincipal();

String token =
jwtService.generateToken(
userDetails);

return ResponseEntity.ok(
new LoginResponse(token));
}
}
