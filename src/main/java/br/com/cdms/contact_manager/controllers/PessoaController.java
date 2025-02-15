package br.com.cdms.contact_manager.controllers;

import br.com.cdms.contact_manager.dtos.PessoaMalaDiretaResponseDTO;
import br.com.cdms.contact_manager.dtos.PessoaRequestDTO;
import br.com.cdms.contact_manager.dtos.PessoaUpdateDTO;
import br.com.cdms.contact_manager.exceptions.PessoaNaoEncontradaException;
import br.com.cdms.contact_manager.models.PessoaModel;
import br.com.cdms.contact_manager.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
    @Autowired
    PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<?> cadastrarPessoa(@Valid @RequestBody PessoaRequestDTO body) {
        pessoaService.cadastrarPessoa(body);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaModel> buscarPessoaPorID(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoaPorID(id));
    }

    @GetMapping("/maladireta/{id}")
    public ResponseEntity<PessoaMalaDiretaResponseDTO> buscarPessoaMalaDiretaPorID(@PathVariable Long id) throws PessoaNaoEncontradaException {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoaMalaDiretaPorID(id));
    }

    @GetMapping
    public ResponseEntity<?> buscarTodasPessoas() {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarTodasAsPessoas());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarPessoaPorID(@PathVariable Long id, @Valid @RequestBody PessoaUpdateDTO body) throws PessoaNaoEncontradaException {
        pessoaService.atualizarPessoaPorId(id, body);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPessoaPorId(@PathVariable Long id) {
        pessoaService.deletarPessoaPorId(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
