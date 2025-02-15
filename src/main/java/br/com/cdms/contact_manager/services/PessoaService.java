package br.com.cdms.contact_manager.services;

import br.com.cdms.contact_manager.dtos.PessoaMalaDiretaResponseDTO;
import br.com.cdms.contact_manager.dtos.PessoaRequestDTO;
import br.com.cdms.contact_manager.dtos.PessoaUpdateDTO;
import br.com.cdms.contact_manager.exceptions.PessoaNaoEncontradaException;
import br.com.cdms.contact_manager.models.PessoaModel;
import br.com.cdms.contact_manager.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    PessoaRepository pessoaRepository;

    @Transactional
    public void cadastrarPessoa(PessoaRequestDTO body) {
        pessoaRepository.save(new PessoaModel(body.nome(), body.endereco(), body.cep(), body.cidade(), body.uf()));
    }

    public PessoaModel buscarPessoaPorID(Long id) throws PessoaNaoEncontradaException{
        return buscarPessoaNoBancoPorID(id);
    }

    public PessoaMalaDiretaResponseDTO buscarPessoaMalaDiretaPorID(Long id) throws PessoaNaoEncontradaException {
        PessoaModel pessoa = buscarPessoaNoBancoPorID(id);

        String cepFormatado = String.format("%s-%s", pessoa.getCep().substring(0, 5), pessoa.getCep().substring(5));

        StringBuilder sb = new StringBuilder();

        sb.append(!pessoa.getEndereco().isBlank() ? pessoa.getEndereco() : "Endereço não informado");
        sb.append(" - CEP: ");
        sb.append(!pessoa.getCep().isBlank() ? cepFormatado : "CEP não informado");
        sb.append(" - ");
        sb.append(!pessoa.getCidade().isBlank() ? pessoa.getCidade() : "Cidade não informada");
        sb.append("/");
        sb.append(pessoa.getUf() != null ? pessoa.getUf() : "UF não informado");

        String malaDireta = sb.toString();

        return new PessoaMalaDiretaResponseDTO(
                pessoa.getId(),
                pessoa.getNome(),
                malaDireta
        );
    }

    public List<PessoaModel> buscarTodasAsPessoas() {
        return pessoaRepository.findAll();
    }

    @Transactional
    public void atualizarPessoaPorId(Long id, PessoaUpdateDTO body) throws PessoaNaoEncontradaException {
        PessoaModel pessoa = buscarPessoaNoBancoPorID(id);

        if(body.nome() != null) {
            pessoa.setNome(body.nome());
        }

        if(body.endereco() != null) {
            pessoa.setEndereco(body.endereco());
        }

        if(body.cep() != null) {
            pessoa.setCep(body.cep());
        }

        if(body.cidade() != null) {
            pessoa.setCidade(body.cidade());
        }

        if(body.uf() != null) {
            pessoa.setUf(body.uf());
        }

        pessoaRepository.save(pessoa);
    }

    @Transactional
    public void deletarPessoaPorId(Long id) {
        pessoaRepository.deleteById(id);
    }

    public PessoaModel buscarPessoaNoBancoPorID(Long id) throws PessoaNaoEncontradaException {
        Optional<PessoaModel> pessoaOptional = pessoaRepository.findById(id);

        if(pessoaOptional.isPresent()) {
            return pessoaOptional.get();
        }
        throw new PessoaNaoEncontradaException();
    }
}
