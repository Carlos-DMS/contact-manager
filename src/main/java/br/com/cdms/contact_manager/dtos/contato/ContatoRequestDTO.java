package br.com.cdms.contact_manager.dtos.contato;

import br.com.cdms.contact_manager.models.enums.TipoContato;
import jakarta.validation.constraints.*;

public record ContatoRequestDTO(
        @NotNull(message = "O campo idPessoa não deve ser nulo.")
        Long idPessoa,
        @NotNull(message = "O campo tipoContato não deve ser nulo.")
        TipoContato tipoContato,
        @NotBlank(message = "O campo contato não deve ser vazio/nulo.")
        @Size(min = 2, max = 100, message = "O campo contato deve ter entre 2 e 100 letras.")
        String contato
) {
}
