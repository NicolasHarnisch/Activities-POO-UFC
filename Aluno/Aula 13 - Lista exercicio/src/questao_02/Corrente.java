package questao_02;

public class Corrente extends Conta {
    private double limiteCheque;
    private double taxaManutenção;

    public Corrente(int numero, String agencia, double saldo, double limiteCheque, double taxaManutenção) {
        super(numero, agencia, saldo);
        this.limiteCheque = limiteCheque;
        this.taxaManutenção = taxaManutenção;
    }

    public double getLimiteCheque() {
        return limiteCheque;
    }

    public void setLimiteCheque(double limiteCheque) {
        this.limiteCheque = limiteCheque;
    }

    public double getTaxaManutenção() {
        return taxaManutenção;
    }

    public void setTaxaManutenção(double taxaManutenção) {
        this.taxaManutenção = taxaManutenção;
    }

    @Override
    public void depositar(double valor) {
        double valorLiquido = valor - this.taxaManutenção;
        setSaldo(getSaldo() + valorLiquido);
        System.out.println("Depósito realizado com taxa de: " + this.taxaManutenção);
    }

    @Override
    public void sacar(double valor) {
        double totalParaSacar = valor + this.taxaManutenção;

        if ((getSaldo() + this.limiteCheque) >= totalParaSacar) {
            setSaldo(getSaldo() - totalParaSacar);
            System.out.println("Saque realizado com taxa de: " + this.taxaManutenção);
        } else {
            System.out.println("Saldo e Limite insuficientes");
        }
    }
}
