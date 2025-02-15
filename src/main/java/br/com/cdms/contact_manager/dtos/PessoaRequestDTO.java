package br.com.cdms.contact_manager.dtos;

import br.com.cdms.contact_manager.models.enums.UF;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

//#TODO: @NullableNotBlank em todas as classes que podem ser nulas.
public record PessoaRequestDTO(
        @NotBlank @Size(min = 2, max = 100, message = "O campo nome deve ter entre 2 e 100 letras.")
        String nome,
        @Size(min = 2, max = 150, message = "O campo endereço deve ter entre 3 e 150 letras.")
        String endereco,
        //Regex: 12345678
        @Pattern(regexp = "^\\d{8}$", message = "O campo CEP deve conter 8 dígitos")
        String cep,
        @Size(min = 3, max = 100, message = "O campo cidade deve ter entre 3 e 100 letras.")
        String cidade,
        //Regex: AZ
        @Pattern(regexp = "^[A-Z]{2}$", message = "O campo UF deve conter 2 letras maiúsculas")
        UF uf
) {
}
