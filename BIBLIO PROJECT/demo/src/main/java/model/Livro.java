package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
    public class Livro {
    @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String titulo;
        private String autor;
        private int anoPublicacao;
    private boolean emprestado;

    public Livro(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public Livro() {

    }

    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public int getAnoPublicacao() {
            return anoPublicacao;
        }

        public void setAnoPublicacao(int anoPublicacao) {
            this.anoPublicacao = anoPublicacao;
        }
    }
