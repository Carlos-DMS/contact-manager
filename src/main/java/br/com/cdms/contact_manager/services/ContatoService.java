package br.com.cdms.contact_manager.services;

import br.com.cdms.contact_manager.dtos.contato.ContatoPessoaEspecificaDTO;
import br.com.cdms.contact_manager.dtos.contato.ContatoRequestDTO;
import br.com.cdms.contact_manager.dtos.contato.ContatoResponseDTO;
import br.com.cdms.contact_manager.dtos.contato.ContatoUpdateDTO;
import br.com.cdms.contact_manager.exceptions.ContatoExistenteException;
import br.com.cdms.contact_manager.exceptions.ContatoNaoEncontradoException;
import br.com.cdms.contact_manager.models.ContatoModel;
import br.com.cdms.contact_manager.models.PessoaModel;
import br.com.cdms.contact_manager.repositories.ContatoRepository;
import br.com.cdms.contact_manager.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {
    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    PessoaService pessoaService;

    @Transactional
    public void cadastrarContato(ContatoRequestDTO body) {
        PessoaModel pessoa = pessoaService.buscarPessoaNoBancoPorID(body.idPessoa());

        ContatoModel contato = new ContatoModel(body.tipoContato(), body.contato(), pessoa);

        if (!pessoa.getContatos().contains(contato)) {
            contatoRepository.save(contato);

            pessoa.addContato(contato);
            pessoaRepository.save(pessoa);
        }
        else {
            throw new ContatoExistenteException();
        }
    }

    public ContatoResponseDTO buscarContatoPorID(Long id) {
        ContatoModel contato = buscarContatoNoBancoPorID(id);

        return new ContatoResponseDTO(
                contato.getId(),
                contato.getTipoContato().getTipoContatoRelatorio(),
                contato.getContato(),
                pessoaService.buscarPessoaPorID(contato.getPessoa().getId())
        );
    }

    public List<ContatoPessoaEspecificaDTO> buscarContatosPorIdPessoa(Long idPessoa) {
        PessoaModel pessoa = pessoaService.buscarPessoaNoBancoPorID(idPessoa);

         return pessoa.getContatos()
                 .stream()
                 .sorted(Comparator.comparing(ContatoModel::getId))
                 .map(contato -> new ContatoPessoaEspecificaDTO(
                         contato.getId(),
                         contato.getTipoContato().getTipoContatoRelatorio(),
                         contato.getContato()
                 )).toList();
    }

    @Transactional
    public void atualizarContatoPorId(Long id, ContatoUpdateDTO body) {
        ContatoModel contato = buscarContatoNoBancoPorID(id);

        if (body.tipoContato() != null) {
            contato.setTipoContato(body.tipoContato());
        }

        if (body.contato() != null) {
            if (!body.contato().isBlank()){
                contato.setContato(body.contato());
            }
        }

        contatoRepository.save(contato);
    }

    @Transactional
    public void deletarContatoPorID(Long id) {
        //A intenção ao buscar o contato, é de lançar uma exceção caso ele não exista.
        contatoRepository.delete(buscarContatoNoBancoPorID(id));
    }

    private ContatoModel buscarContatoNoBancoPorID(Long id) {
        Optional<ContatoModel> contato = contatoRepository.findById(id);

        if (contato.isPresent()) {
            return contato.get();
        }
        throw new ContatoNaoEncontradoException();
    }
}
