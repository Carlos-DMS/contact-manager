package br.com.cdms.contact_manager.services;

import br.com.cdms.contact_manager.dtos.pessoa.PessoaMalaDiretaResponseDTO;
import br.com.cdms.contact_manager.dtos.pessoa.PessoaRequestDTO;
import br.com.cdms.contact_manager.dtos.pessoa.PessoaResponseDTO;
import br.com.cdms.contact_manager.dtos.pessoa.PessoaUpdateDTO;
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

    public PessoaResponseDTO buscarPessoaPorID(Long id) {
        PessoaModel pessoa = buscarPessoaNoBancoPorID(id);

        return new PessoaResponseDTO(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getCep(),
                pessoa.getCep(),
                pessoa.getCidade(),
                pessoa.getUf()
        );
    }

    public PessoaMalaDiretaResponseDTO buscarPessoaMalaDiretaPorID(Long id) {
        PessoaModel pessoa = buscarPessoaNoBancoPorID(id);

        String cepFormatado = null;
        if (pessoa.getCep() != null) {
            cepFormatado = String.format("%s-%s", pessoa.getCep().substring(0, 5), pessoa.getCep().substring(5));
        }

        StringBuilder sb = new StringBuilder();

        sb.append(pessoa.getEndereco() != null ? pessoa.getEndereco() : "Endereço não informado");
        sb.append(" - CEP: ");
        sb.append(pessoa.getCep() != null ? cepFormatado : "CEP não informado");
        sb.append(" - ");
        sb.append(pessoa.getCidade() != null ? pessoa.getCidade() : "Cidade não informada");
        sb.append("/");
        sb.append(pessoa.getUf() != null ? pessoa.getUf() : "UF não informado");

        String malaDireta = sb.toString();

        return new PessoaMalaDiretaResponseDTO(
                pessoa.getId(),
                pessoa.getNome(),
                malaDireta
        );
    }

    public List<PessoaResponseDTO> buscarTodasAsPessoas() {
        return pessoaRepository.findAll().stream().map(
                pessoa -> new PessoaResponseDTO(
                        pessoa.getId(),
                        pessoa.getNome(),
                        pessoa.getEndereco(),
                        pessoa.getCep(),
                        pessoa.getCidade(),
                        pessoa.getUf())
        ).toList();
    }

    @Transactional
    public void atualizarPessoaPorId(Long id, PessoaUpdateDTO body) {
        PessoaModel pessoa = buscarPessoaNoBancoPorID(id);

        if (body.nome() != null) {
            if (!body.nome().isBlank()) {
                pessoa.setNome(body.nome());
            }
        }

        pessoa.setEndereco(body.endereco());
        pessoa.setCep(body.cep());
        pessoa.setCidade(body.cidade());
        pessoa.setUf(body.uf());

        pessoaRepository.save(pessoa);
    }

    @Transactional
    public void deletarPessoaPorId(Long id) {
        //A intenção ao buscar a pessoa, é de lançar uma exceção caso ela não exista.
        pessoaRepository.delete(buscarPessoaNoBancoPorID(id));
    }

    public PessoaModel buscarPessoaNoBancoPorID(Long id) {
        Optional<PessoaModel> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isPresent()) {
            return pessoaOptional.get();
        }

        throw new PessoaNaoEncontradaException();
    }
}
