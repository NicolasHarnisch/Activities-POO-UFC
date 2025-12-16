package questao_03;

public class Aluguel extends Imovel {
    private double valorAluguel;
    private double taxaManutencao;

    public Aluguel(String endereco, int areaQuadrados, double valorBase, double valorAluguel, double taxaManutencao) {
        super(endereco, areaQuadrados, valorBase);
        this.valorAluguel = valorAluguel;
        this.taxaManutencao = taxaManutencao;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public double getTaxaManutencao() {
        return taxaManutencao;
    }

    public void setTaxaManutencao(double taxaManutencao) {
        this.taxaManutencao = taxaManutencao;
    }

    @Override
    public double getValorMensal() {
        if (getCliente() != null) {
            return getValorAluguel() + getTaxaManutencao();
        }
        return 0.0;
    }

}
