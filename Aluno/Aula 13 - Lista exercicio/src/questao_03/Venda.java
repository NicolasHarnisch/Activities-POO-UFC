package questao_03;

public class Venda extends Imovel {
    private double comissaoImobiliaria;

    public Venda(String endereco, int areaQuadrados, double valorBase, double comissaoImobiliaria) {
        super(endereco, areaQuadrados, valorBase);
        this.comissaoImobiliaria = comissaoImobiliaria;
    }

    public double getComissaoImobiliaria() {
        return comissaoImobiliaria;
    }

    public void setComissaoImobiliaria(double comissaoImobiliaria) {
        this.comissaoImobiliaria = comissaoImobiliaria;
    }

}
