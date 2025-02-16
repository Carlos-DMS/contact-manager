package br.com.cdms.contact_manager.controllers;

import br.com.cdms.contact_manager.exceptions.ContatoExistenteException;
import br.com.cdms.contact_manager.exceptions.ContatoNaoEncontradoException;
import br.com.cdms.contact_manager.exceptions.PessoaNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//#TODO: implementar handler para os erros do Validation
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    //PESSOA EXCEPTIONS

    @ExceptionHandler(PessoaNaoEncontradaException.class)
    private ResponseEntity<String> pessoaNaoEncontradaHandler(PessoaNaoEncontradaException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    //CONTATO EXCEPTIONS

    @ExceptionHandler(ContatoNaoEncontradoException.class)
    private ResponseEntity<String> contatoNaoEncontradoHandler(ContatoNaoEncontradoException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ContatoExistenteException.class)
    private ResponseEntity<String> contatoExistenteHandler(ContatoExistenteException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    //OUTRAS EXCEÇÕES

    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> excecaoGenericaHandler(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + exception.getMessage());
    }
}
