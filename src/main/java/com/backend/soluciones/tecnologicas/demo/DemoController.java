package com.backend.soluciones.tecnologicas.demo;

import com.backend.soluciones.tecnologicas.auth.AuthService;
import com.backend.soluciones.tecnologicas.auth.ValidTokenResponse;
import com.backend.soluciones.tecnologicas.jwt.JwtService;
import com.backend.soluciones.tecnologicas.user.Role;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(DemoController.class);
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @PostMapping(value = "demo")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome from secure endpoint") ;
    }

    @PostMapping(value = "validToken")
    public ValidTokenResponse validToken (@RequestHeader("Authorization") String bearerToken){
        var t = bearerToken.substring(7);
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtService.getUsernameFromToken(t));
        var res = jwtService.isTokenValid(t, userDetails);
        return ValidTokenResponse.builder().response(res).build();
    }
}
