package questao_01;

public class Mensalista extends Funcionarios {

    public Mensalista(String nome, String cpf, double salarioBase) {
        super(nome, cpf, salarioBase);
    }

    @Override
    public double calcularSalarioLiquido() {
        return getSalarioBase() * 0.86;
    }
}
