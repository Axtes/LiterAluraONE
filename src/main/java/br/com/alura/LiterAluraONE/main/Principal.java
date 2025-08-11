package br.com.alura.LiterAluraONE.main;

import br.com.alura.LiterAluraONE.DTO.DTOLivros;
import br.com.alura.LiterAluraONE.DTO.DTOResultados;
import br.com.alura.LiterAluraONE.model.Autor;
import br.com.alura.LiterAluraONE.model.Livro;
import br.com.alura.LiterAluraONE.repository.AutorRepository;
import br.com.alura.LiterAluraONE.repository.LivroRepository;
import br.com.alura.LiterAluraONE.service.ConsumoApi;
import br.com.alura.LiterAluraONE.service.ConverteDados;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConverteDados conversor = new ConverteDados();
    private final String ENDERECO = "https://gutendex.com/books/?search=";
    private LivroRepository livroRepository;
    private AutorRepository autorRepository;
    private List<Autor> autores;
    private List<Livro> livros;

    public Principal(LivroRepository livroRepository, AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
    }

    public void exibirMenu() {
        int opcao = -1;
        while (opcao != 0) {

            var menu = """
                    1 - buscar livro pelo título
                    2 - listar livros registrados
                    3 - listar autores registrados
                    4 - listar autores vivos em um determinado ano
                    5 - listar livros em um determinado idioma
                    0 - sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    buscarLivro();
                    break;
                case 2:
                    listagemLivrosRegistrados();
                    break;
                case 3:
                    listagemAutoresRegistrados();
                    break;
                case 4:
                    buscarAutorVivoEmDeterminadoAno();
                    break;
                case 5:
                    listarLivrosPorIdioma();
                    break;
                case 0:
                    System.out.println("Encerrando a aplicação...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void buscarLivro() {
        System.out.println("Digite o nome do livro para busca");
        var nomeLivro = leitura.nextLine();
        var json = consumo.obterDados(ENDERECO + nomeLivro.replace(" ", "+").toLowerCase());
        DTOResultados dtoResultados = conversor.obterDados(json, DTOResultados.class);

        DTOLivros livroEncontrado = dtoResultados.resultados().get(0);

        Livro livro = new Livro(livroEncontrado);
        System.out.println(livro);

        Autor autor = autorJaExiste(livroEncontrado.autor().get(0).nome(), livroEncontrado.autor().get(0).anoNascimento());
        livro.setAutor(autor);
        livroRepository.save(livro);
    }

    private void listagemLivrosRegistrados(){
        livros = livroRepository.findAllWithAutores();
        livros.stream()
                .sorted(Comparator.comparing(l -> l.getAutor().getNome()))
                .forEach(System.out::println);
    }

    private void listagemAutoresRegistrados(){
        autores = autorRepository.findAll();
        autores.stream()
                .sorted(Comparator.comparing(a -> a.getNome()))
                .forEach(System.out::println);
    }

    private Autor autorJaExiste(String nome, Integer anoNascimento) {
        Autor autorExistente = autorRepository.findByNomeAndAnoNascimento(nome, anoNascimento);
        if (autorExistente != null) {
            return autorRepository.getReferenceById(autorExistente.getId());
        } else {
            Autor novoAutor = new Autor();
            novoAutor.setNome(nome);
            novoAutor.setAnoNascimento(anoNascimento);
            return autorRepository.save(novoAutor);
        }
    }

    private void buscarAutorVivoEmDeterminadoAno(){
        System.out.println("Digite o ano que pesquisar");
        var anoEscolhido = leitura.nextInt();

        autores = autorRepository.findAllByAno(anoEscolhido);
        autores.forEach(System.out::println);
    }

    private void listarLivrosPorIdioma() {
        System.out.println("""
                Insira o idioma para realizar a busca:
                Es - Espanhol
                En - Inglês
                Fr - Francês
                Pt - Português
                """);

        String idiomaBuscado = leitura.nextLine();
        livros = livroRepository.findAllByIdioma(idiomaBuscado.toLowerCase());
        livros.forEach(System.out::println);
    }
}


