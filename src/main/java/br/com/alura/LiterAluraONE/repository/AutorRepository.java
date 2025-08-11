package br.com.alura.LiterAluraONE.repository;

import br.com.alura.LiterAluraONE.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    Autor findByNomeAndAnoNascimento(String nome, Integer anoNascimento);

    @Query("SELECT a FROM Autor a WHERE a.anoNascimento <= :anoBuscado AND (a.anoFalecimento IS NULL OR a.anoFalecimento >= :anoBuscado)")
    List<Autor> findAllByAno(Integer anoBuscado);
}
