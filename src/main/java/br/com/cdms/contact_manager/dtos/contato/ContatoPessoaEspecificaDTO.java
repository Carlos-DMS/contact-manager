package br.com.cdms.contact_manager.dtos.contato;

import io.swagger.v3.oas.annotations.media.Schema;

public record ContatoPessoaEspecificaDTO(
        @Schema(
                description = "Identificador númerico do contato",
                example = "1"
        )
        Long id,

        @Schema(
                description = "Tipo de contato utilizado para comunicação.",
                example = "Email",
                allowableValues = {
                        "EMAIL", "CELULAR", "WHATSAPP",
                        "TELEGRAM", "SKYPE", "DISCORD",
                        "MICROSOFT_TEAMS", "LINKEDIN", "GITHUB"
                }
        )
        String tipoContato,

        @Schema(
                description = "Informações de contato de uma pessoa",
                example = "seuemail@email.com"
        )
        String contato
) {
}
