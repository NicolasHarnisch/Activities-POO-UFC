package questao_01;

import java.util.ArrayList;

public class SistemaFuncionarios {
    private ArrayList<Funcionarios> funcionarios;

    public SistemaFuncionarios() {
        this.funcionarios = new ArrayList<>();
    }

    public ArrayList<Funcionarios> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionarios> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void cadastrarFuncionario(Funcionarios funcionarios) {
        this.funcionarios.add(funcionarios);
    }

    public void calcularFolhaDePagamento() {
        for (Funcionarios f : this.funcionarios) {
            System.out.println("Nome: " + f.getNome());
            System.out.println("CPF: " + f.getCpf());
            System.out.println("Salario Liquido: R$ " + f.calcularSalarioLiquido());
        }
    }

    public static void main(String[] args) {
        SistemaFuncionarios sistema = new SistemaFuncionarios();

        Funcionarios f1 = new Horistas("Nícolas Harnisch", "100.200.300-50", 0, 80, 50.00);
        Funcionarios f2 = new Mensalista("Joice Manuela", "200.300.500-49", 5000.00);

        sistema.cadastrarFuncionario(f1);
        sistema.cadastrarFuncionario(f2);

        sistema.calcularFolhaDePagamento();
    }

}
