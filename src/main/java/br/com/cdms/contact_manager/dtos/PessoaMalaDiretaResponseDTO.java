package br.com.cdms.contact_manager.dtos;

public record PessoaMalaDiretaResponseDTO(
        Long id,
        String nome,
        String malaDireta
) {
}
