package com.backend.soluciones.tecnologicas.tipoDocumento;

import com.backend.soluciones.tecnologicas.auth.AuthResponse;
import com.backend.soluciones.tecnologicas.auth.AuthService;
import com.backend.soluciones.tecnologicas.auth.RegisterRequest;
import com.backend.soluciones.tecnologicas.citas.Citas;
import com.backend.soluciones.tecnologicas.user.User;
import com.backend.soluciones.tecnologicas.user.UserRepository;
import jakarta.transaction.UserTransaction;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TipoDocumentoService {
    Logger logger = LoggerFactory.getLogger(TipoDocumentoService.class);
    private final TipoDocumentoRepository tipoDocumentoRepository;

    @Transactional
    public TipoDocumentoResponse register(TipoDocumentoRequest request) {



        TipoDocumento tipoDocumento = TipoDocumento.builder()
                .tipodocNombre(request.getTipodocNombre())
                .build();

        tipoDocumentoRepository.save(tipoDocumento);

        return TipoDocumentoResponse.builder()
                .tipodocId(tipoDocumento.getTipodocId())
                .build();

    }
}
