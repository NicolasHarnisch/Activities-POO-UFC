package questao_03;

public abstract class Imovel {
    private String endereco;
    private int areaQuadrados;
    private double valorBase;
    private Cliente cliente;

    public Imovel(String endereco, int areaQuadrados, double valorBase) {
        this.endereco = endereco;
        this.areaQuadrados = areaQuadrados;
        this.valorBase = valorBase;
        this.cliente = null;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getAreaQuadrados() {
        return areaQuadrados;
    }

    public void setAreaQuadrados(int areaQuadrados) {
        this.areaQuadrados = areaQuadrados;
    }

    public double getValorBase() {
        return valorBase;
    }

    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getValorMensal() {
        return 0.0;
    }
}
