package com.backend.soluciones.tecnologicas.auth;

import com.backend.soluciones.tecnologicas.user.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String username;
    String password;
    String firstname;
    String lastname;
    String document;
    String address;
    String phone;
    Role role;
    Boolean state;
    String enterprise;
}
