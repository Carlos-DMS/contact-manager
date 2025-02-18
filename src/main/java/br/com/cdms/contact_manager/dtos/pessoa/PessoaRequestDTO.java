package br.com.cdms.contact_manager.dtos.pessoa;

import br.com.cdms.contact_manager.validation.constraints.NullableNotBlank;
import br.com.cdms.contact_manager.validation.constraints.ValidUF;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PessoaRequestDTO(
        @Schema(
                description = "Nome da pessoa",
                example = "João Silva"
        )
        @NotBlank(message = "O campo nome não deve ser vazio/nulo.")
        @Size(min = 2, max = 100, message = "O campo nome deve ter entre 2 e 100 letras.")
        String nome,

        @Schema(
                description = "Endereço da pessoa",
                example = "Rua Fictícia, 123"
        )
        @NullableNotBlank(message = "O campo endereco não deve ser vazio.")
        @Size(min = 3, max = 150, message = "O campo endereco deve ter entre 3 e 150 letras.")
        String endereco,

        @Schema(
                description = "CEP da rua onde a pessoa mora",
                example = "12345678"
        )
        @NullableNotBlank(message = "O campo cep não deve ser vazio.")
        @Pattern(regexp = "^\\d{8}$", message = "O campo CEP deve conter 8 dígitos.")
        String cep,

        @Schema(
                description = "Cidade onde a pessoa mora",
                example = "São Paulo"
        )
        @NullableNotBlank(message = "O campo cidade não deve ser vazio.")
        @Size(min = 3, max = 100, message = "O campo cidade deve ter entre 3 e 100 letras.")
        String cidade,

        @Schema(
                description = "Unidade Federativa (UF) da pessoa",
                example = "SP",
                allowableValues = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
                "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
                "RS", "RO", "RR", "SC", "SP", "SE", "TO"}
        )
        @ValidUF
        String uf
) {
}
