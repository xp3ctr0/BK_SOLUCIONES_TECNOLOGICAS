package com.backend.soluciones.tecnologicas.auth;

import com.backend.soluciones.tecnologicas.exception.BusinessException;
import com.backend.soluciones.tecnologicas.exception.RequestException;
import com.backend.soluciones.tecnologicas.jwt.JwtService;
import com.backend.soluciones.tecnologicas.user.Role;
import com.backend.soluciones.tecnologicas.user.User;
import com.backend.soluciones.tecnologicas.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthService {

    Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(@RequestBody LoginRequest request) {

        User user = userRepository.findByUsername(request.getUsername())
                        .orElseThrow(() -> new AuthenticationCredentialsNotFoundException("Invalid Login"));

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token=jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .role(user.getRole().toString())
                .build();
    }

    public AuthResponse register(RegisterRequest request) {

        logger.info(String.valueOf(request));

        User user = User.builder()
                .document(request.getDocument())
                .username(request.getUsername())
                .password(passwordEncoder.encode( request.getPassword()))
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .address(request.getAddress())
                .phone(request.getPhone())
                .role(request.getRole())
                .tipoDocumento(request.getTipoDocumento())
                .state(request.getState())
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .role(String.valueOf(user.getRole()))
                .build();

    }
}
