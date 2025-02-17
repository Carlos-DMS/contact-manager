package br.com.cdms.contact_manager.models;

import br.com.cdms.contact_manager.models.enums.TipoContato;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="tb_contato")
public class ContatoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 2)
    private TipoContato tipoContato;
    @Column(nullable = false, length = 100)
    private String contato;
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    PessoaModel pessoa;

    public ContatoModel() {
    }

    public ContatoModel(String tipoContato, String contato, PessoaModel pessoa) {

        this.tipoContato = tipoContato != null ? TipoContato.valueOf(tipoContato.toUpperCase()) : null;
        this.contato = contato;
        this.pessoa = pessoa;
    }

    public Long getId() {
        return id;
    }

    public TipoContato getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(String tipoContato) {
        this.tipoContato = tipoContato != null ? TipoContato.valueOf(tipoContato.toUpperCase()) : null;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public PessoaModel getPessoa() {
        return pessoa;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContatoModel that = (ContatoModel) o;
        return tipoContato == that.tipoContato && Objects.equals(contato, that.contato) && Objects.equals(pessoa, that.pessoa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoContato, contato, pessoa);
    }
}
