package br.com.cdms.contact_manager.controllers;

import br.com.cdms.contact_manager.controllers.openAPI.ContatoControllerOpenAPI;
import br.com.cdms.contact_manager.dtos.contato.ContatoPessoaEspecificaDTO;
import br.com.cdms.contact_manager.dtos.contato.ContatoRequestDTO;
import br.com.cdms.contact_manager.dtos.contato.ContatoResponseDTO;
import br.com.cdms.contact_manager.dtos.contato.ContatoUpdateDTO;
import br.com.cdms.contact_manager.services.ContatoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController implements ContatoControllerOpenAPI {
    @Autowired
    ContatoService contatoService;

    @PostMapping
    public ResponseEntity<Void> cadastrarContato(@Valid @RequestBody ContatoRequestDTO body) {
        contatoService.cadastrarContato(body);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContatoResponseDTO> buscarContatoPorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.buscarContatoPorID(id));
    }

    @GetMapping("/pessoa/{idPessoa}")
    public ResponseEntity<List<ContatoPessoaEspecificaDTO>> buscarContatosPorIdPessoa(@PathVariable Long idPessoa) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.buscarContatosPorIdPessoa(idPessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarContatoPorId(@PathVariable Long id, @Valid @RequestBody ContatoUpdateDTO body) {
        contatoService.atualizarContatoPorId(id, body);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContatoPorId(@PathVariable Long id) {
        contatoService.deletarContatoPorID(id);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
