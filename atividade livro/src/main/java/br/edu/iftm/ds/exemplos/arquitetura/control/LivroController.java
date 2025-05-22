package br.edu.iftm.ds.exemplos.arquitetura.control;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import br.edu.iftm.ds.exemplos.arquitetura.domain.Livro;
import br.edu.iftm.ds.exemplos.arquitetura.repository.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public void cadastrarLivro(@RequestParam String titulo,
                                @RequestParam String autor,
                                @RequestParam int anoPublicacao,
                                @RequestParam String isbn) {
        Livro livro = new Livro(titulo, autor, anoPublicacao, isbn);
        repository.salvar(livro);
    }

    @GetMapping
    public List<Livro> listarTodos(@RequestParam(required = false) String titulo,
                                   @RequestParam(required = false) String autor) {
        if (titulo != null) return repository.buscarPorTitulo(titulo);
        if (autor != null) return repository.buscarPorAutor(autor);
        return repository.buscarTodos();
    }

    @GetMapping("/{isbn}")
    public Livro buscarPorIsbn(@PathVariable String isbn) {
        return repository.buscarPorIsbn(isbn);
    }
}
