package br.com.alura.LiterAluraONE.model;

import br.com.alura.LiterAluraONE.DTO.DTOAutores;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nome", "ano_nascimento"})
})
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer anoNascimento;
    private Integer anoFalecimento;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "autor")
    private List<Livro> livros = new ArrayList<>();

    public Autor(){}

    public Autor(DTOAutores dtoAutores) {
        this.nome = dtoAutores.nome();
        this.anoNascimento = dtoAutores.anoNascimento();
        this.anoFalecimento = dtoAutores.anoFalecimento();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return """
                --------------------
                Autor: %s
                Ano de Nascimento: %d
                Ano de Falecimento: %d
                Livros: %s
                --------------------
                """.formatted(nome, anoNascimento,anoFalecimento,livros.stream()
                .map(l -> l.getTitulo()).collect(Collectors.toList()));
    }
}
