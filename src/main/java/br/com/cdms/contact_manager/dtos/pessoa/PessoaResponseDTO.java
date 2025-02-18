package br.com.cdms.contact_manager.dtos.pessoa;

import br.com.cdms.contact_manager.models.enums.UF;
import io.swagger.v3.oas.annotations.media.Schema;

public record PessoaResponseDTO(
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
                description = "Endereço da pessoa",
                example = "Rua Fictícia, 123"
        )
        String endereco,

        @Schema(
                description = "CEP da rua onde a pessoa mora",
                example = "12345678"
        )
        String cep,

        @Schema(
                description = "Cidade onde a pessoa mora",
                example = "São Paulo"
        )
        String cidade,

        @Schema(
                description = "Unidade Federativa (UF) da pessoa",
                example = "SP",
                allowableValues = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
                        "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
                        "RS", "RO", "RR", "SC", "SP", "SE", "TO"}
        )
        UF uf
) {
}
