package questao_01;

public class Horistas extends Funcionarios {
    private int qtdHorasTrabalhadas;
    private double valorHoras;

    public Horistas(String nome, String cpf, double salarioBase, int qtdHorasTrabalhadas, double valorHoras) {
        super(nome, cpf, salarioBase);
        this.qtdHorasTrabalhadas = qtdHorasTrabalhadas;
        this.valorHoras = valorHoras;
    }

    public int getQtdHorasTrabalhadas() {
        return qtdHorasTrabalhadas;
    }

    public void setQtdHorasTrabalhadas(int qtdHorasTrabalhadas) {
        this.qtdHorasTrabalhadas = qtdHorasTrabalhadas;
    }

    public double getValorHoras() {
        return valorHoras;
    }

    public void setValorHoras(double valorHoras) {
        this.valorHoras = valorHoras;
    }

    @Override
    public double calcularSalarioLiquido() {
        return getSalarioBase() + qtdHorasTrabalhadas * valorHoras;
    }
}
