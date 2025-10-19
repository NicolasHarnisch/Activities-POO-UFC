public class PagamentoDinheiro extends Pagamento {
    
    private double valorRecebido;
    private double troco;

    public PagamentoDinheiro(double valor, String data, double valorRecebido) {
        super(valor, data, false);
        this.valorRecebido = valorRecebido;
    }

    @Override
    public boolean processarPagamento() {
        if (this.isConfirma_pagamento()) {
            System.out.println("Pagamento já foi processado anteriormente.\n");
            return false;
        }

        if (valorRecebido < this.getValor()) {
            System.out.println("Pagamento não processado. O valor recebido é menor que o valor da compra.\n");
            return false;
        }

        this.troco = this.valorRecebido - this.getValor();
        return super.processarPagamento();
    }

    @Override
    void exibirComprovante() {
        super.exibirComprovante();
        System.out.println("Valor Recebido: " + valorRecebido);
        System.out.println("Troco: " + String.format("%.2f", this.troco) + "\n");
    }
}