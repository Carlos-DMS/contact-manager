package br.com.cdms.contact_manager.controllers;

import br.com.cdms.contact_manager.controllers.openAPI.PessoaControllerOpenAPI;
import br.com.cdms.contact_manager.dtos.pessoa.PessoaMalaDiretaResponseDTO;
import br.com.cdms.contact_manager.dtos.pessoa.PessoaRequestDTO;
import br.com.cdms.contact_manager.dtos.pessoa.PessoaResponseDTO;
import br.com.cdms.contact_manager.dtos.pessoa.PessoaUpdateDTO;
import br.com.cdms.contact_manager.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController implements PessoaControllerOpenAPI {
    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Void> cadastrarPessoa(@Valid @RequestBody PessoaRequestDTO body) {
        pessoaService.cadastrarPessoa(body);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponseDTO> buscarPessoaPorID(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoaPorID(id));
    }

    @GetMapping("/maladireta/{id}")
    public ResponseEntity<PessoaMalaDiretaResponseDTO> buscarPessoaMalaDiretaPorID(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoaMalaDiretaPorID(id));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponseDTO>> buscarTodasPessoas() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarTodasAsPessoas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarPessoaPorID(@PathVariable Long id, @Valid @RequestBody PessoaUpdateDTO body) {
        pessoaService.atualizarPessoaPorId(id, body);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoaPorId(@PathVariable Long id) {
        pessoaService.deletarPessoaPorId(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
