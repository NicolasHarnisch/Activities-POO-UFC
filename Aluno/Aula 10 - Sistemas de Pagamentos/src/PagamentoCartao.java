public class PagamentoCartao extends Pagamento {

    private String numeroCartao;
    private String bandeira;
    private int quantidadeParcelas;
    private double valorParcela;

    public PagamentoCartao(double valor, String data, String numeroCartao, String bandeira, int quantidadeParcelas, int valorParcela) {
        super(valor, data, false);
        this.numeroCartao = numeroCartao;
        this.bandeira = bandeira;
        this.quantidadeParcelas = quantidadeParcelas;
    }

    @Override
    public boolean processarPagamento() {
        if (this.isConfirma_pagamento()) {
            System.out.println("Pagamento com cartão já foi processado.\n");
            return false;
        }

        if (this.quantidadeParcelas <= 0) {
            System.out.println("Pagamento não processado. O número de parcelas é inválido.\n");
            return false;
        }

        this.valorParcela = this.getValor() / this.quantidadeParcelas;
        return super.processarPagamento();
        
    }

    @Override
    void exibirComprovante() {
        super.exibirComprovante();
        System.out.println("Bandeira: " + this.bandeira);
        System.out.println("Cartão: " + mascararNumeroCartao());
        System.out.println("Parcelas: " + this.quantidadeParcelas + "x de R$ " + String.format("%.2f", this.valorParcela) + "\n");
        
    }

    private String mascararNumeroCartao() {
        String ultimosDigitos = this.numeroCartao.substring(this.numeroCartao.length() - 4);
        return "**** **** **** " + ultimosDigitos;
    }
}


