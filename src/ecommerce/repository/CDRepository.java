package ecommerce.repository;

import livraria.model.CD;
import livraria.model.Produto;
import java.util.ArrayList;
import java.util.List;

import ecommerce.repository.EcommerceRepository;

public class CDRepository implements EcommerceRepository {
    private List<CD> cds = new ArrayList<>();

    @Override
    public void adicionar(Produto produto) {
        cds.add((CD) produto);
        System.out.println("CD adicionado: " + produto.getTitulo());
    }

    @Override
    public void remover(String titulo) {
        cds.removeIf(cd -> cd.getTitulo().equals(titulo));
        System.out.println("CD removido: " + titulo);
    }

    @Override
    public void atualizar(Produto produto) {
        for (int i = 0; i < cds.size(); i++) {
            if (cds.get(i).getTitulo().equals(produto.getTitulo())) {
                cds.set(i, (CD) produto);
                System.out.println("CD atualizado: " + produto.getTitulo());
                return;
            }
        }
        System.out.println("CD não encontrado para atualizar.");
    }

    @Override
    public Produto buscarPorTitulo(String titulo) {
        for (CD cd : cds) {
            if (cd.getTitulo().equals(titulo)) {
                return cd;
            }
        }
        System.out.println("CD não encontrado.");
        return null;
    }

    @Override
    public List<Produto> listarTodos() {
        return new ArrayList<>(cds);
    }
}
