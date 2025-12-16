package questao_03;

import java.util.ArrayList;

public class SistemaImoveis {
    private ArrayList<Imovel> listaImoveis;
    private ArrayList<Cliente> listaCliente;

    public SistemaImoveis() {
        this.listaImoveis = new ArrayList<>();
        this.listaCliente = new ArrayList<>();
    }

    public void cadastrarImovel(Imovel imovel) {
        this.listaImoveis.add(imovel);
        System.out.println("Imóvel cadastrado com sucesso");
    }

    public void cadastrarCliente(Cliente cliente) {
        this.listaCliente.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " cadastrado com sucesso");
    }

    public void ClienteImovel(Cliente cliente, Imovel imovel) {
        imovel.setCliente(cliente);
        System.out.println("Cliente associado ao imóvel!");
    }

    public double calculoValorVenda(Venda venda) {
        return venda.getValorBase() + (venda.getValorBase() * (venda.getComissaoImobiliaria() / 100));
    }

    public double alugueisAtivos() {
        double totalArrecadado = 0;

        for (Imovel imovel : listaImoveis) {
            totalArrecadado += imovel.getValorMensal();
        }
        return totalArrecadado;
    }

    //(IA) metodo adicional para testar
    public void listarImoveis() {
        System.out.println("--- Relatório Final ---");
        for (Imovel i : listaImoveis) {
            System.out.println("Endereço: " + i.getEndereco() + " | Cliente: " + (i.getCliente() != null ? i.getCliente().getNome() : "Vago"));
        }
    }

    public static void main() {
        SistemaImoveis sistema = new SistemaImoveis();

        Cliente c1 = new Cliente("Nícolas Harnisch", "100.200.300-50", "(85) 996883588");
        Cliente c2 = new Cliente("Manuela", "555.666.777-88", "(85) 98888-1111");

        sistema.cadastrarCliente(c1);
        sistema.cadastrarCliente(c2);

        Venda v1 = new Venda("Rua Cel. Perdigão", 50, 200000.00, 5.0);

        Aluguel a1 = new Aluguel("Rua Barbosa Santos", 40, 180000.00, 1900.00, 100.00);

        sistema.cadastrarImovel(v1);
        sistema.cadastrarImovel(a1);

        sistema.ClienteImovel(c1, a1);

        System.out.println("\n--- Cálculos ---");

        double valorFinalVenda = sistema.calculoValorVenda(v1);
        System.out.println("Valor Final de Venda: R$ " + valorFinalVenda);

        double totalAluguel = sistema.alugueisAtivos();
        System.out.println("Total Arrecadado Aluguéis Ativos: R$ " + totalAluguel);

        System.out.println();

        sistema.listarImoveis();
    }
}