public class Caminhao extends Veiculo {
    double cargaAtual;
    
    public Caminhao(String placa, String modelo, int capacidade, double combustivel, double cargaAtual){
        super(placa, modelo, capacidade, combustivel);
        this.cargaAtual = cargaAtual;
    }

    double viajar(double distancia) {
        double consumoPorKm = 1.2 + (0.2 * cargaAtual);
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
        System.out.println("Peso Atual da Carga: " + cargaAtual);
    }

}
