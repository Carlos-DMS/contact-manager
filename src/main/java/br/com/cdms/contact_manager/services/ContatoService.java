package br.com.cdms.contact_manager.services;

import br.com.cdms.contact_manager.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {
    @Autowired
    ContatoRepository contatoRepository;
}
