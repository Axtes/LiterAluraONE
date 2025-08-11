package br.com.alura.LiterAluraONE.repository;

import br.com.alura.LiterAluraONE.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("SELECT l FROM Livro l JOIN FETCH l.autor")
    List<Livro> findAllWithAutores();

    @Query("SELECT l FROM Livro l JOIN FETCH l.autor WHERE LOWER(l.idioma) LIKE %:idiomaBuscado%")
    List<Livro> findAllByIdioma(@Param("idiomaBuscado") String idiomaBuscado);
}
