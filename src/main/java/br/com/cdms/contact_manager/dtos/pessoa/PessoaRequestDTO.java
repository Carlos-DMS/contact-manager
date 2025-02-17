package br.com.cdms.contact_manager.dtos.pessoa;

import br.com.cdms.contact_manager.models.enums.UF;
import br.com.cdms.contact_manager.validation.constraints.NullableNotBlank;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PessoaRequestDTO(
        @NotBlank(message = "O campo nome não deve ser vazio/nulo.")
        @Size(min = 2, max = 100, message = "O campo nome deve ter entre 2 e 100 letras.")
        String nome,
        @NullableNotBlank(message = "O campo endereco não deve ser vazio.")
        @Size(min = 3, max = 150, message = "O campo endereco deve ter entre 3 e 150 letras.")
        String endereco,
        //Regex: 12345678
        @NullableNotBlank(message = "O campo cep não deve ser vazio.")
        @Pattern(regexp = "^\\d{8}$", message = "O campo CEP deve conter 8 dígitos.")
        String cep,
        @NullableNotBlank(message = "O campo cidade não deve ser vazio.")
        @Size(min = 3, max = 100, message = "O campo cidade deve ter entre 3 e 100 letras.")
        String cidade,
        UF uf
) {
}
