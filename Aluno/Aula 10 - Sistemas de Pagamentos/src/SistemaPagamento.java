import java.util.ArrayList;
import java.util.List;

public class SistemaPagamento {
    private List<Pagamento> pagamentos;

    public SistemaPagamento() {
        this.pagamentos = new ArrayList<>();
    }

    public void registrarPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento); 
        System.out.println("Pagamento registrado com sucesso.");
    }

    public void processarTodosPagamentos() {
        System.out.println("\n--- PROCESSANDO TODOS OS PAGAMENTOS ---\n");
        for (Pagamento pg : pagamentos) {
            pg.processarPagamento();
            System.out.println("---");
        }
    }

    public void exibirTodosComprovantes() {
        System.out.println("\n--- EXIBINDO TODOS OS COMPROVANTES ---\n");
        for (Pagamento pg : pagamentos) {
            pg.exibirComprovante();
            System.out.println(); 
        }
    }

    public static void main(String[] args) {
        SistemaPagamento sistema = new SistemaPagamento();

        sistema.registrarPagamento(new PagamentoDinheiro(100, "19/10/2025", 120));
        sistema.registrarPagamento(new PagamentoDinheiro(50, "19/10/2025", 40)); 

        sistema.registrarPagamento(new PagamentoCartao(10000, "18/10/2025", "1234 5678 9101 1121", "Master", 12, 0));

        sistema.registrarPagamento(new PagamentoPix(500, "01/09/2024", false, "85 996883588", "Nubank"));

        sistema.processarTodosPagamentos();
        sistema.exibirTodosComprovantes();
    }
}