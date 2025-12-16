public class Conta {
    private int numero;
    private int agencia;
    private String nome;
    private double saldo;

    Conta(int numero, int agencia, String nome, double saldo) {
        this.numero = numero;
        this.agencia = agencia;
        this.nome = nome;
        this.saldo = saldo;
    }

    public Conta() {

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    boolean depositar(double valor) {
        if(valor <= 0) return false;
        this.saldo += valor;
        return true;
    }

    boolean sacar(double valor) {
        if(valor <= 0 || valor > saldo) return false;
        this.saldo -= valor;
        return true;
    }

    boolean transferir(double valor, Conta conta) {
        if(!this.sacar(valor)) return false;
        if(!conta.depositar(valor)) {
            this.saldo += valor;
            return false;
        }
        return true;
    }

}