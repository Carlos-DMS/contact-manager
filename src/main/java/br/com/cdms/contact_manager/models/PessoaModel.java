package br.com.cdms.contact_manager.models;

import br.com.cdms.contact_manager.models.enums.UF;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="tb_pessoa")
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = true, length = 150)
    private String endereco;
    @Column(nullable = true, length = 8)
    private String cep;
    @Column(nullable = true, length = 100)
    private String cidade;
    @Column(nullable = true, length = 2)
    private UF uf;
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ContatoModel> contatos = new HashSet<>();

    public PessoaModel() {
    }

    public PessoaModel(String nome, String endereco, String cep, String cidade, String uf) {
        this.nome = nome;
        this.endereco = endereco;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf != null ? UF.valueOf(uf.toUpperCase()) : null;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf != null ? UF.valueOf(uf.toUpperCase()) : null;
    }

    public Set<ContatoModel> getContatos() {
        return contatos;
    }

    public void addContato(ContatoModel contato) {
        contatos.add(contato);
    }
}
