package livraria.model;

public class Livro extends Produto {
    private String autor;
    private String categoria;
    private int quantidadeEstoque;

    public Livro(String titulo, String autor, String categoria, double preco, int quantidadeEstoque) {
        super(titulo, preco);
        this.autor = autor;
        this.categoria = categoria;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public void visualizar() {
        super.visualizar();  
        System.out.println("Autor: " + this.autor);
        System.out.println("Categoria: " + this.categoria);
        System.out.println("Quantidade no estoque: " + this.quantidadeEstoque);
    }

    public void visualizar(String formato) {
        if (formato.equals("detalhado")) {
            System.out.println("Livro Detalhado: ");
            visualizar();  
        } else {
            System.out.println("Título: " + this.titulo);
        }
    }
}
