package questao_04;

public class Professor extends Pessoa {
    private double salarioBase;
    private int aulasMinistradas;

    public Professor(String nome, String cpf, double salarioBase, int aulasMinistradas) {
        super(nome, cpf);
        this.salarioBase = salarioBase;
        this.aulasMinistradas = aulasMinistradas;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getAulasMinistradas() {
        return aulasMinistradas;
    }

    public void setAulasMinistradas(int aulasMinistradas) {
        this.aulasMinistradas = aulasMinistradas;
    }

    public double pagamentoMensal() {
        return this.salarioBase + this.aulasMinistradas * 50;
    }
}
