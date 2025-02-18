package br.com.cdms.contact_manager.dtos.contato;

import br.com.cdms.contact_manager.validation.constraints.ValidTipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

public record ContatoRequestDTO(
        @Schema(
                description = "Identificador númerico da pessoa",
                example = "1"
        )
        @NotNull(message = "O campo idPessoa não deve ser nulo.")
        Long idPessoa,

        @Schema(
                description = "Tipo de contato utilizado para comunicação.",
                example = "EMAIL",
                allowableValues = {
                        "EMAIL", "CELULAR", "WHATSAPP",
                        "TELEGRAM", "SKYPE", "DISCORD",
                        "MICROSOFT_TEAMS", "LINKEDIN", "GITHUB"
                }
        )
        @NotNull(message = "O campo tipoContato não deve ser nulo.")
        @ValidTipoContato
        String tipoContato,

        @Schema(
                description = "Informações de contato de uma pessoa",
                example = "seuemail@email.com"
        )
        @NotBlank(message = "O campo contato não deve ser vazio/nulo.")
        @Size(min = 2, max = 100, message = "O campo contato deve ter entre 2 e 100 letras.")
        String contato
) {
}
