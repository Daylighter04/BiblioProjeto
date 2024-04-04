package service;

import model.Livro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LivroRepository;

@Service
public interface LivroServiceImpl extends LivroService {
    @Autowired
    LivroRepository livroRepository = null;

    @Override
    public default Livro salvar(Livro livro) {
        return livroRepository.save(livro);
    }

    @Override
    public default Livro buscarPorId(Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    @Override
    public default void deletar(Long id) {
        livroRepository.deleteById(id);
    }
    @Override
    public default Livro emprestar(Long id) {
        Livro livro = livroRepository.findById(id).orElse(null);
        if (livro != null && !livro.isEmprestado()) {
            livro.setEmprestado(true);
            return livroRepository.save(livro);
        }
        return null;
    }

    @Override
    public default Livro devolver(Long id) {
        Livro livro = livroRepository.findById(id).orElse(null);
        if (livro != null && livro.isEmprestado()) {
            livro.setEmprestado(false);
            return livroRepository.save(livro);
        }
        return null;
    }
}
