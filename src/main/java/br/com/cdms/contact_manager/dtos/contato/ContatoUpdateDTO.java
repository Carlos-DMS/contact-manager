package br.com.cdms.contact_manager.dtos.contato;

import br.com.cdms.contact_manager.validation.constraints.NullableNotBlank;
import br.com.cdms.contact_manager.validation.constraints.ValidTipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;

public record ContatoUpdateDTO(
        @Schema(
                description = "Tipo de contato utilizado para comunicação.",
                example = "EMAIL",
                allowableValues = {
                        "EMAIL", "CELULAR", "WHATSAPP",
                        "TELEGRAM", "SKYPE", "DISCORD",
                        "MICROSOFT_TEAMS", "LINKEDIN", "GITHUB"
                }
        )
        @ValidTipoContato
        String tipoContato,

        @Schema(
                description = "Informações de contato de uma pessoa",
                example = "seuemail@email.com"
        )
        @NullableNotBlank(message = "O campo contato não deve ser vazio")
        @Size(min = 2, max = 100, message = "O campo contato deve ter entre 2 e 100 letras.")
        String contato
) {
}
