public class Pagamento {

    private double valor;
    private String data;
    private boolean confirmar_pagamento;

    Pagamento(double valor, String data, boolean confirmar_pagamento) {
        this.valor = valor;
        this.data = data;
        this.confirmar_pagamento = false;
    }

    public boolean processarPagamento() {
        if (this.confirmar_pagamento) {
            System.out.println("Pagamento já foi processado anteriormente.\n");
            return false;
        }
        this.confirmar_pagamento = true;
        System.out.println("Pagamento processado com sucesso!\n");
        return true;
    }

    void exibirComprovante() {
        System.out.println("----- Comprovante de Pagamento -----");
        System.out.println("Valor: " + valor);
        System.out.println("Data: " + data);
        System.out.println("Status: " + (confirmar_pagamento ? "Confirmado" : "Não confirmado"));
        System.out.println("------------------------------------\n");
    }

    public double getValor() {
        return valor;
    }

    public boolean isConfirma_pagamento() {
        return confirmar_pagamento;
    }
}
