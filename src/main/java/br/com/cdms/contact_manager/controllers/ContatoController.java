package br.com.cdms.contact_manager.controllers;

import br.com.cdms.contact_manager.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
    @Autowired
    ContatoService contatoService;

    /*
    @PostMapping
    public ResponseEntity<> cadastrarContato() {}

    @GetMapping("/{ìd}")
    public ResponseEntity<> buscarContatoPorId(@PathVariable Long id) {}

    @GetMapping("/{ìdPessoa}")
    public ResponseEntity<> buscarContatosPorIdPessoa(@PathVariable Long id) {}

    @PutMapping("/{id}")
    public ResponseEntity<> atualizarContatoPorId(@PathVariable Long id) {}

    @DeleteMapping("/{id}")
    public ResponseEntity<> deletarContatoPorId(@PathVariable Long id) {}
    */
}
