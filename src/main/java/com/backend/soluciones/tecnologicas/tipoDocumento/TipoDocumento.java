package com.backend.soluciones.tecnologicas.tipoDocumento;

import com.backend.soluciones.tecnologicas.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tipodocumento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tipodocId;
    @Column(nullable = false, columnDefinition = "varchar(20)", unique = true)
    private String tipodocNombre;

    @OneToMany(mappedBy = "tipoDocumento")
    private List<User> user;
}
