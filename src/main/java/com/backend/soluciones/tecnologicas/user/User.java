package com.backend.soluciones.tecnologicas.user;

import java.util.Collection;
import java.util.List;

import com.backend.soluciones.tecnologicas.tipoDocumento.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String lastname;
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String firstname;
    @Column(unique = true, columnDefinition = "varchar(20)")
    private String username;
    @Column(unique = true, columnDefinition = "varchar(20)")
    private String document;
    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String password;
    private String address;
    @Column(nullable = false, columnDefinition = "varchar(10)")
    private String phone;
    @Column(columnDefinition = "boolean default true")
    private Boolean state;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tipoDocumento", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private TipoDocumento tipoDocumento;

    @Enumerated(EnumType.STRING)
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
