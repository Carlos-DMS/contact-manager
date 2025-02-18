package br.com.cdms.contact_manager.dtos;

import io.swagger.v3.oas.annotations.media.Schema;

public record ExemploCampoInvalidoDTO(
        @Schema(
                description = "Campo inválido, e motivo do erro.",
                example = "O campo X não pode ser nulo."
        )
        String campo
) {
}
