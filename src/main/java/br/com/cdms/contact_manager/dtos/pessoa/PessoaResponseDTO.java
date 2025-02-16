package br.com.cdms.contact_manager.dtos.pessoa;

import br.com.cdms.contact_manager.models.enums.UF;

public record PessoaResponseDTO(
        Long id,
        String nome,
        String endereco,
        String cep,
        String cidade,
        UF uf
) {
}
