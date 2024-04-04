package controller;

import model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping("/")
    public ResponseEntity<Livro> adicionarLivro(@RequestBody Livro livro) {
        Livro livroSalvo = livroService.salvar(livro);
        return new ResponseEntity<>(livroSalvo, HttpStatus.CREATED);
    }

    @PostMapping("/livros")
    public Livro salvar(@RequestBody Livro livro) {
        return livroService.salvar(livro);
    }

    @GetMapping("/{id}")
    public Livro buscarPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        livroService.deletar(id);
    }
    @PostMapping("/{id}/emprestar")
    public Livro emprestar(@PathVariable Long id) {
        return livroService.emprestar(id);
    }

    @PostMapping("/{id}/devolver")
    public Livro devolver(@PathVariable Long id) {
        return livroService.devolver(id);
    }
}
