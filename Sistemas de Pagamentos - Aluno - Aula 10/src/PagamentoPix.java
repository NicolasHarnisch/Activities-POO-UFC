public class PagamentoPix extends Pagamento{

    private String chavePix;
    private String bancoOrigem;

    public PagamentoPix(double valor, String data, boolean confirmar_pagamento, String chavePix, String bancoOrigem) {
        super(valor, data, false);
        this.chavePix = chavePix;
        this.bancoOrigem= bancoOrigem;
    }

    @Override
    public void exibirComprovante() {
            super.exibirComprovante();
            System.out.println("Chave PIX: " + this.chavePix);
            System.out.println("Banco de Origem: " + this.bancoOrigem + "\n");
    }
}
