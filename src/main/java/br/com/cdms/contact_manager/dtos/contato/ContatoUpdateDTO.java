package br.com.cdms.contact_manager.dtos.contato;

import br.com.cdms.contact_manager.models.enums.TipoContato;
import jakarta.validation.constraints.Size;

public record ContatoUpdateDTO(
        //Regex: ABC...
        //TODO: @ValidTipoContato
        TipoContato tipoContato,
        @Size(min = 2, max = 100, message = "O campo contato deve ter entre 2 e 100 letras.")
        String contato
) {
}
