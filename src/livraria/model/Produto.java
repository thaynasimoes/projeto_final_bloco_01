package livraria.model;

public abstract class Produto {
    protected String titulo;
    protected double preco;

    public Produto(String titulo, double preco) {
        this.titulo = titulo;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void visualizar() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Preço: " + this.preco);
    }

}
