package com.backend.soluciones.tecnologicas.tipoDocumento;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TipoDocumentoRequest {
    @NotEmpty(message = "TipoDoc is mandatory")
    private String tipodocNombre;
}
