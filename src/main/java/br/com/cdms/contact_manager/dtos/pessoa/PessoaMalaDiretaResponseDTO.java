package br.com.cdms.contact_manager.dtos.pessoa;

import io.swagger.v3.oas.annotations.media.Schema;

public record PessoaMalaDiretaResponseDTO(
        @Schema(
                description = "Identificador númerico da pessoa",
                example = "1"
        )
        Long id,

        @Schema(
                description = "Nome da pessoa",
                example = "João Silva"
        )
        String nome,

        @Schema(
                description = "Conjunto de informações referente ao local onde a pessoa mora",
                example = "Rua fictícia, 123 - CEP: 12345-678 - São Paulo/SP"
        )
        String malaDireta
) {
}
