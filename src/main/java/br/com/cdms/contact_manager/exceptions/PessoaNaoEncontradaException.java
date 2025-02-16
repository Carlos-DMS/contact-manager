package br.com.cdms.contact_manager.exceptions;

public class PessoaNaoEncontradaException extends RuntimeException{
    public PessoaNaoEncontradaException() {
        super("Não foi possível encontrar essa pessoa no banco de dados.");
    }
}
