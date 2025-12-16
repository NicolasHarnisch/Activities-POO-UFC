package questao_02;

import java.util.ArrayList;

public class SistemaBancario {
    private ArrayList<Cliente> listaCliente;

    public SistemaBancario() {
        this.listaCliente = new ArrayList<>();
    }

    public void cadastrarClientes(Cliente cliente) {
        this.listaCliente.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso");
    }

    public void cadastrarConta(Conta novaConta, String cpfTitular) {
        for (Cliente cliente : this.listaCliente) {
            if (cliente.getCpf().equals(cpfTitular)) {
                cliente.adicionarConta(novaConta);
                System.out.println("Conta cadastrada para " + cliente.getNome());

                return;
            }
        }
        System.out.println("Cliente não encontrado");
    }

    public void listarContaCliente(String cpf) {
        for (Cliente cliente : this.listaCliente) {
            if (cliente.getCpf().equals(cpf)) {
                System.out.println("Contas do cliente " + cliente.getNome() + ":");

                for (Conta conta : cliente.getContas()) {
                    System.out.println("- Conta: " + conta.getNumero() + " | Saldo: " + conta.consultarSaldo());
                }
                return;
            }
        }
        System.out.println("Cliente não encontrado");
    }

    public double realizarSaque(int numeroConta, double valor) {
        for (Cliente clienteAtual : this.listaCliente) {
            for (Conta contaAtual : clienteAtual.getContas()) {

                if (contaAtual.getNumero() == numeroConta) {
                    contaAtual.sacar(valor);

                    return contaAtual.consultarSaldo();
                }
            }
        }
        System.out.println("Conta não encontrada");
        return -1.0;
    }

    public double realizarDeposito(int numeroConta, double valor) {
        for (Cliente clienteAtual : this.listaCliente) {
            for (Conta contaAtual : clienteAtual.getContas()) {

                if (contaAtual.getNumero() == numeroConta) {
                    contaAtual.depositar(valor);

                    return contaAtual.consultarSaldo();
                }
            }
        }
        System.out.println("Conta não encontrada");
        return -1.0;
    }

    public void listarSaldoContas() {
        System.out.println("\n--- RELATÓRIO GERAL ---");

        for (Cliente cliente : this.listaCliente) {
            System.out.println("Cliente: " + cliente.getNome());

            for (Conta conta : cliente.getContas()) {
                System.out.println("   Conta " + conta.getNumero() + ": R$ " + conta.consultarSaldo());
            }
        }
    }

    public static class Main {
        public static void main(String[] args) {
            SistemaBancario banco = new SistemaBancario();

            Cliente cliente1 = new Cliente("João Silva", "111.222.333-00");
            Cliente cliente2 = new Cliente("Maria Oliveira", "999.888.777-00");

            banco.cadastrarClientes(cliente1);
            banco.cadastrarClientes(cliente2);

            System.out.println("--------------------------------------------------");

            Conta contaCorrenteJoao = new Corrente(101, "Ag-A", 1000.00, 500.00, 5.00);
            Conta contaPoupancaMaria = new Poupanca(202, "Ag-B", 500.00, 0.02);

            banco.cadastrarConta(contaCorrenteJoao, "111.222.333-00");
            banco.cadastrarConta(contaPoupancaMaria, "999.888.777-00");

            System.out.println("--------------------------------------------------");

            banco.listarContaCliente("111.222.333-00");

            System.out.println("--------------------------------------------------");

            double saldoMaria = banco.realizarDeposito(202, 100.00);
            System.out.println("Novo saldo da Maria após depósito: " + saldoMaria);

            double saldoJoao = banco.realizarSaque(101, 200.00);
            System.out.println("Novo saldo do João após saque: " + saldoJoao);

            double nicolas = banco.realizarSaque(9999, 50.00);

            System.out.println("--------------------------------------------------");

            banco.listarSaldoContas();
        }
    }
}