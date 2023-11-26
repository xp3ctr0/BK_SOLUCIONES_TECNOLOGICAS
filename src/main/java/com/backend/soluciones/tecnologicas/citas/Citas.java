package com.backend.soluciones.tecnologicas.citas;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long citaId;
    @Column(nullable = false, columnDefinition = "Date")
    private Date citaFecha;
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String citaHora;
    @Column(nullable = false, columnDefinition = "varchar(20)")
    private String citaTipoServicio;
    @Column(nullable = false, columnDefinition = "varchar(255)")
    private String citaDesc;
    @Column(nullable = false, columnDefinition = "boolean")
    private Boolean citaEstado;
}
