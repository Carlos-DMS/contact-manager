package br.com.cdms.contact_manager.controllers;

import br.com.cdms.contact_manager.services.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/contatos")
public class ContatoController {
    @Autowired
    ContatoService contatoService;
}
