import java.util.ArrayList;

public class SistemaTransporte {
    private ArrayList<Veiculo> veiculos; // Lista de veículos registrados

    // Construtor
    public SistemaTransporte() {
        veiculos = new ArrayList<>();
    }

    // Método para registrar um novo veículo
    public void registrarVeiculo(Veiculo v) {
        if (v != null) {
            veiculos.add(v);
            System.out.println("Veículo registrado: " + v.getModelo() + " (" + v.getPlaca() + ")");
        } else {
            System.out.println("Erro: veículo inválido.");
        }
    }

    // Método que simula viagens de todos os veículos (uso de polimorfismo)
    public void realizarViagens(double distancia) {
        System.out.println("\n--- Iniciando viagens ---");
        for (Veiculo v : veiculos) {
            System.out.println("\n>>> Veículo: " + v.getModelo());
            v.viajar(distancia); // método polimórfico
        }
    }

    // Método para exibir todos os veículos registrados
    public void exibirRelatorio() {
        System.out.println("\n===== RELATÓRIO DE VEÍCULOS =====");
        for (Veiculo v : veiculos) {
            v.exibirDados(); // polimorfismo: cada tipo de veículo exibe informações diferentes
            System.out.println("-------------------------------");
        }
    }

    // Método principal apenas para teste
    public static void main(String[] args) {
        SistemaTransporte sistema = new SistemaTransporte();

        // Criando alguns veículos
        Onibus onibus = new Onibus("ABC-1234", "Marcopolo", 50, 300, 40);
        Caminhao caminhao = new Caminhao("XYZ-9876", "Volvo FH", 2, 500, 10);
        Carro carro = new Carro("DEF-5678", "Corolla", 5, 50, true);

        // Registrando veículos no sistema
        sistema.registrarVeiculo(onibus);
        sistema.registrarVeiculo(caminhao);
        sistema.registrarVeiculo(carro);

        // Simulando uma viagem de 100 km
        sistema.realizarViagens(100);

        // Exibindo relatório final
        sistema.exibirRelatorio();
    }
}

