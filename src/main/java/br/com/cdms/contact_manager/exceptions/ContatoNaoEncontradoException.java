package br.com.cdms.contact_manager.exceptions;

public class ContatoNaoEncontradoException extends RuntimeException {
    public ContatoNaoEncontradoException() {
        super("Não foi possível encontrar esse contato no banco de dados.");
    }
}
