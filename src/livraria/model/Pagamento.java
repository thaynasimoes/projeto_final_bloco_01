package livraria.model;

public class Pagamento {

    private double valor;
    private boolean pago;

    public Pagamento(double valor, boolean pago) {
        this.valor = valor;
        this.pago = pago;
    }

    public boolean processarPagamento() {
        if (!pago) {
            System.out.println("Processando pagamento de R$" + valor);
            pago = true;
            System.out.println("Pagamento realizado com sucesso!");
            return true;
        } else {
            System.out.println("Pagamento não pode ser realizado. Já está pago.");
            return false;
        }
    }

    public boolean reembolsarPagamento() {
        if (pago) {
            System.out.println("Reembolsando pagamento de R$" + valor);
            pago = false;
            System.out.println("Reembolso realizado com sucesso!");
            return true;
        } else {
            System.out.println("Não é possível reembolsar. Pagamento ainda não foi realizado.");
            return false;
        }
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }
}
