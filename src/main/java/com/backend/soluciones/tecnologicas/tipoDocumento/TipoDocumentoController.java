package com.backend.soluciones.tecnologicas.tipoDocumento;

import com.backend.soluciones.tecnologicas.auth.AuthResponse;
import com.backend.soluciones.tecnologicas.auth.AuthService;
import com.backend.soluciones.tecnologicas.auth.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/v1")
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequiredArgsConstructor
public class TipoDocumentoController {

    private final TipoDocumentoService tipoDocumentoService;
    @PostMapping(value = "tipodoc")
    public ResponseEntity<TipoDocumentoResponse> register(@Valid @RequestBody TipoDocumentoRequest request) {
        return ResponseEntity.ok(tipoDocumentoService.register(request));
    }
}
