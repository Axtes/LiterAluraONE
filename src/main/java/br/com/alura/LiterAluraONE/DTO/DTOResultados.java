package br.com.alura.LiterAluraONE.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DTOResultados(@JsonAlias("results") List<DTOLivros> resultados) {
}
