package ecommerce.repository;

import livraria.model.Produto;
import java.util.List;

public interface EcommerceRepository {
    void adicionar(Produto produto);
    void remover(String titulo);
    void atualizar(Produto produto);
    Produto buscarPorTitulo(String titulo);
    List<Produto> listarTodos();
}
