package livraria.model;

public class CD extends Produto {
    private String artista;
    private int numeroFaixas;

    public CD(String titulo, String artista, double preco, int numeroFaixas) {
        super(titulo, preco);
        this.artista = artista;
        this.numeroFaixas = numeroFaixas;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Artista: " + this.artista);
        System.out.println("Número de faixas: " + this.numeroFaixas);
    }
}
