package br.com.cdms.contact_manager.controllers.openAPI;

import br.com.cdms.contact_manager.dtos.pessoa.PessoaMalaDiretaResponseDTO;
import br.com.cdms.contact_manager.dtos.pessoa.PessoaRequestDTO;
import br.com.cdms.contact_manager.dtos.pessoa.PessoaResponseDTO;
import br.com.cdms.contact_manager.dtos.pessoa.PessoaUpdateDTO;
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

@Tag(name = "Pessoa", description = "Operações envolvendo pessoas.")
public interface PessoaControllerOpenAPI {

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pessoa cadastrada com sucesso."),
            @ApiResponse(
                    responseCode = "400",
                    description = "Um ou mais parâmetros inseridos são inválidos.",
                    content = @Content(schema = @Schema(type = "string", example = "Erros"))
            )
    })
    @Operation(
            summary = "Cadastrar pessoa.",
            description = "Cadastra uma entidade pessoa."
    )
    ResponseEntity<Void> cadastrarPessoa(@Valid @RequestBody PessoaRequestDTO body);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A busca foi realizada com sucesso."),
            @ApiResponse(
                    responseCode = "404",
                    description = "A pessoa referente ao ID inserido não existe.",
                    content = @Content(schema = @Schema(type = "string", example = "Não foi possível encontrar essa pessoa no banco de dados."))
            )
    })
    @Operation(
            summary = "Buscar pessoa por ID.",
            description = "Busca uma pessoa referente ao ID inserido."
    )
    ResponseEntity<PessoaResponseDTO> buscarPessoaPorID(@Parameter(description = "ID da pessoa", example = "1") @PathVariable Long id);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "A busca foi realizada com sucesso."),
            @ApiResponse(
                    responseCode = "404",
                    description = "A pessoa referente ao ID inserido não existe.",
                    content = @Content(schema = @Schema(type = "string", example = "Não foi possível encontrar essa pessoa no banco de dados."))
            )
    })
    @Operation(
            summary = "Buscar uma pessoa e suas informações de mala direta pelo ID.",
            description = "Busca uma pessoa referente ao ID, juntamente com suas informações de mala direta ."
    )
    ResponseEntity<PessoaMalaDiretaResponseDTO> buscarPessoaMalaDiretaPorID(@Parameter(description = "ID da pessoa", example = "1") @PathVariable Long id);

    @ApiResponses(value = @ApiResponse(responseCode = "200", description = "A busca foi realizada com sucesso."))
    @Operation(
            summary = "Buscar todas as pessoas.",
            description = "Busca todas as pessoas cadastradas."
    )
    ResponseEntity<List<PessoaResponseDTO>> buscarTodasPessoas();

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa atualizada com sucesso."),
            @ApiResponse(
                    responseCode = "404",
                    description = "A pessoa referente ao ID inserido não existe.",
                    content = @Content(schema = @Schema(type = "string", example = "Não foi possível encontrar essa pessoa no banco de dados."))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Um ou mais parâmetros inseridos são inválidos.",
                    content = @Content(schema = @Schema(type = "string", example = "Erros"))
            )
    })
    @Operation(
            summary = "Atualiza uma pessoa.",
            description = "Atualiza os atributos de uma pessoa identificada pelo ID."
    )
    ResponseEntity<Void> atualizarPessoaPorID(@Parameter(description = "ID da pessoa", example = "1") @PathVariable Long id, @Valid @RequestBody PessoaUpdateDTO body);

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pessoa deletada com sucesso"),
            @ApiResponse(
                    responseCode = "404",
                    description = "A pessoa referente ao ID inserido não existe.",
                    content = @Content(schema = @Schema(type = "string", example = "Não foi possível encontrar essa pessoa no banco de dados."))
            )
    })
    @Operation(
            summary = "Deletar pessoa.",
            description = "Deleta uma pessoa identificada pelo ID."
    )
    ResponseEntity<Void> deletarPessoaPorId(@Parameter(description = "ID da pessoa", example = "1") @PathVariable Long id);
}
