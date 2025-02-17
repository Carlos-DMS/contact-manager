package br.com.cdms.contact_manager.dtos.contato;

import br.com.cdms.contact_manager.models.enums.TipoContato;
import br.com.cdms.contact_manager.validation.constraints.NullableNotBlank;
import jakarta.validation.constraints.Size;

public record ContatoUpdateDTO(
        TipoContato tipoContato,
        @NullableNotBlank(message = "O campo contato não deve ser vazio (pode ser nulo)")
        @Size(min = 2, max = 100, message = "O campo contato deve ter entre 2 e 100 letras.")
        String contato
) {
}
