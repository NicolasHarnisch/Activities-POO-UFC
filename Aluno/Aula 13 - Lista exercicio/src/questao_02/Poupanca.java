package questao_02;

public class Poupanca extends Conta {
    private double taxaRendimento;

    public Poupanca(int numero, String agencia, double saldo, double taxaRendimento) {
        super(numero, agencia, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    public void depositar(double valor) {
        double valorRendimento = valor + (valor * this.taxaRendimento);
        setSaldo(getSaldo() + valorRendimento);
        System.out.println("Depósito de R$" + valor + " realizado com rendimento de: " + (valor * this.taxaRendimento));
    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$" + valor + " realizado na poupança");
        } else {
            System.out.println("Saldo insuficiente para saque na poupança");
        }
    }

}
