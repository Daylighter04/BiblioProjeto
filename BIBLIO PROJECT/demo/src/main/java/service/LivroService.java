package service;

import model.Livro;

public interface LivroService {
    Livro salvar(Livro livro);
    Livro buscarPorId(Long id);
    void deletar(Long id);
    Livro emprestar (Long id);
    Livro devolver(Long id);
}
