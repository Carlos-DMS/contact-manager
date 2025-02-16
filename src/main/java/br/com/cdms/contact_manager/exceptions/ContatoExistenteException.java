package br.com.cdms.contact_manager.exceptions;

public class ContatoExistenteException extends RuntimeException {
    public ContatoExistenteException() {
        super("O contato inserido já estava cadastrado.");
    }
}
