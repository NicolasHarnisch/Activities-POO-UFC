public class Carro extends Veiculo {
    boolean arCondicionadoLigado;

    public Carro(String placa, String modelo, int capacidade, double combustivel, boolean arCondicionadoLigado){
        super(placa, modelo, capacidade, combustivel);
        this.arCondicionadoLigado = arCondicionadoLigado;
    }
    
    double viajar(double distancia) {
        double consumoPorKm = 0.15 + 0.10;
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
        System.out.println("Ar Condicionado ligado? " + arCondicionadoLigado);
    }
}
