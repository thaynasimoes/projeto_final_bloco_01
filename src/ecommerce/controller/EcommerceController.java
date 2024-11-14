package ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import ecommerce.repository.EcommerceRepository;
import livraria.model.Produto;

public class EcommerceController implements EcommerceRepository {

    private ArrayList<Produto> listaProdutos = new ArrayList<>();
    
    @Override
    public void adicionar(Produto produto) {
        listaProdutos.add(produto);
    }

    @Override
    public void remover(String titulo) {
        listaProdutos.removeIf(produto -> produto.getTitulo().equalsIgnoreCase(titulo));
    }

    @Override
    public void atualizar(Produto produto) {
        for (int i = 0; i < listaProdutos.size(); i++) {
            if (listaProdutos.get(i).getTitulo().equalsIgnoreCase(produto.getTitulo())) {
                listaProdutos.set(i, produto);
                break;
            }
        }
    }

    @Override
    public Produto buscarPorTitulo(String titulo) {
        for (Produto produto : listaProdutos) {
            if (produto.getTitulo().equalsIgnoreCase(titulo)) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        return listaProdutos;
    }
    
    
}
