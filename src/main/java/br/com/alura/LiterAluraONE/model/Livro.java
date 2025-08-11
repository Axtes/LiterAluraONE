package br.com.alura.LiterAluraONE.model;

import br.com.alura.LiterAluraONE.DTO.DTOLivros;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private String idioma;
    private Integer totalDownloads;

    public Livro(){}

    public Livro(DTOLivros livros) {
        this.titulo = livros.titulo();
        Autor autores = new Autor(livros.autor().get(0));
        this.autor = autores;
        this.idioma = livros.idiomas().get(0);
        this.totalDownloads = livros.totalDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getTotalDownloads() {
        return totalDownloads;
    }

    public void setTotalDownloads(Integer totalDownloads) {
        this.totalDownloads = totalDownloads;
    }

    @Override
    public String toString() {
        return """
                ----- LIVRO -----
                Título: %s
                Autor: %s
                Idioma: %s
                Número de downloads: %d
                -----------------
                """.formatted(titulo, autor.getNome(), idioma, totalDownloads);
    }
}
