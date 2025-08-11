package br.com.alura.LiterAluraONE.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
