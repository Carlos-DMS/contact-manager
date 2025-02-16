package br.com.cdms.contact_manager.dtos.contato;

import br.com.cdms.contact_manager.dtos.pessoa.PessoaResponseDTO;

public record ContatoResponseDTO(
        Long id,
        String tipoContato,
        String contato,
        PessoaResponseDTO pessoa
) {
}
