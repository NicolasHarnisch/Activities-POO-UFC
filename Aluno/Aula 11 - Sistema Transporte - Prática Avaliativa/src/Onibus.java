public class Onibus extends Veiculo {
    int quantidadePassageiros;

    public Onibus(String placa, String modelo, int capacidade, double combustivel, int quantidadePassageiros){
        super(placa, modelo, capacidade, combustivel);
        this.quantidadePassageiros = quantidadePassageiros;
    }

    double viajar(double distancia) {
        double consumoPorKm = 0.5 + (0.01 * quantidadePassageiros);
        double consumoTotal = consumoPorKm * distancia;

        if (getCombustivel() >= consumoTotal) { 
            setCombustivel(getCombustivel() - consumoTotal);
            System.out.println("Viagem realizada com sucesso");
            return consumoTotal;
        } else {
            System.out.println("Viagem não realizada, falta de combustivel");
            return 0;
        }
    }

    void exibirDados(){
        super.exibirDados();
        System.out.println("Quantidade de Passageiros: " + quantidadePassageiros);
    }
}

