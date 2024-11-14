package ecommerce.repository;

import livraria.model.Livro;
import livraria.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class LivroRepository implements EcommerceRepository {
    private List<Livro> livros = new ArrayList<>();

    @Override
    public void adicionar(Produto produto) {
        livros.add((Livro) produto);
        System.out.println("Livro adicionado: " + produto.getTitulo());
    }

    @Override
    public void remover(String titulo) {
        livros.removeIf(livro -> livro.getTitulo().equals(titulo));
        System.out.println("Livro removido: " + titulo);
    }

    @Override
    public void atualizar(Produto produto) {
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().equals(produto.getTitulo())) {
                livros.set(i, (Livro) produto);
                System.out.println("Livro atualizado: " + produto.getTitulo());
                return;
            }
        }
        System.out.println("Livro não encontrado para atualizar.");
    }

    @Override
    public Produto buscarPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        System.out.println("Livro não encontrado.");
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        return new ArrayList<>(livros);
    }
}
