package br.com.cdms.contact_manager.controllers.openAPI;

import br.com.cdms.contact_manager.dtos.contato.ContatoRequestDTO;
import br.com.cdms.contact_manager.dtos.contato.ContatoResponseDTO;
import br.com.cdms.contact_manager.dtos.contato.ContatoUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(name = "Contato", description = "Operações envolvendo contatos de pessoas.")
public interface ContatoControllerOpenAPI {
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contato cadastrado com sucesso."),
            @ApiResponse(responseCode = "409", description = "O contato já estava cadastrado."),
            @ApiResponse(
                    responseCode = "400",
                    description = "Um ou mais parâmetros inseridos são inválidos.",
                    content = @Content(schema = @Schema(type = "string", example = "Erros"))
            )
    })
    @Operation(
            summary = "Cadastrar contato.",
            description = "Cadastra uma entidade contato."
    )
    ResponseEntity<Void> cadastrarContato(@Valid @RequestBody ContatoRequestDTO body);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A busca foi realizada com sucesso."),
            @ApiResponse(
                    responseCode = "404",
                    description = "O contato referente ao ID inserido não existe.",
                    content = @Content(schema = @Schema(type = "string", example = "Não foi possível encontrar esse contato no banco de dados."))
            )
    })
    @Operation(
            summary = "Buscar contato por ID.",
            description = "Busca um contato referente ao ID inserido."
    )
    ResponseEntity<ContatoResponseDTO> buscarContatoPorId(@Parameter(description = "ID do contato", example = "1") @PathVariable Long id);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A busca foi realizada com sucesso."),
            @ApiResponse(
                    responseCode = "404",
                    description = "Erro.",
                    content = @Content(schema = @Schema(type = "string", example = "Mensagem de erro."))
            )
    })
    @Operation(
            summary = "Buscar contatos de pessoa por ID.",
            description = "Busca contatos vinculados ao ID de uma pessoa específica"
    )
    ResponseEntity<List<ContatoResponseDTO>> buscarContatosPorIdPessoa(@Parameter(description = "ID da pessoa", example = "1") @PathVariable Long idPessoa);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contato cadastrado com sucesso."),
            @ApiResponse(responseCode = "409", description = "O contato já estava cadastrado."),
            @ApiResponse(responseCode = "400", description = "Um ou mais parâmetros inseridos são inválidos.")
    })
    @Operation(
            summary = "Atualizar contato.",
            description = "Atualiza os atributos de um contato identificado pelo ID."
    )
    ResponseEntity<Void> atualizarContatoPorId(@Parameter(description = "ID do contato", example = "1") @PathVariable Long id, @Valid @RequestBody ContatoUpdateDTO body);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Contato cadastrado com sucesso."),
            @ApiResponse(responseCode = "409", description = "O contato já estava cadastrado."),
            @ApiResponse(
                    responseCode = "400",
                    description = "Um ou mais parâmetros inseridos são inválidos.",
                    content = @Content(schema = @Schema(type = "string", example = "Erros"))
            )
    })
    @Operation(
            summary = "Deleta um contato.",
            description = "Deleta um contato identificado pelo ID."
    )
    ResponseEntity<Void> deletarContatoPorId(@Parameter(description = "ID do contato", example = "1") @PathVariable Long id);
}
