abstract class Veiculo {
    private String placa;
    private String modelo;
    private int capacidade;
    private double combustivel;

    public Veiculo(String placa, String modelo, int capacidade, double combustivel) {
        this.placa = placa;
        this.modelo = modelo;
        this.capacidade = capacidade;
        this.combustivel = combustivel;
    }

    public double abastecer(double litros) {
        combustivel += litros;
        return combustivel;
    }

    abstract double viajar(double distancia);

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }

    void exibirDados(){
        System.out.println("----- Informações do Veículo -----");
        System.out.println("Placa: " + placa);
        System.out.println("Modelo: " + modelo);
        System.out.println("Capacidade de pessoas: " + capacidade);
        System.out.println("Quntidade de Combustivel: " + combustivel);
    }
}
