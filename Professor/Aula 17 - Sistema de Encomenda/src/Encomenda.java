public class Encomenda {
	
	private int codigo;
	private double peso;
	private String destino;
	private FuncionarioEntrega entregador;
	
	Encomenda(int codigo, double peso, String destino, FuncionarioEntrega entregador) {
		this.codigo = codigo;
		this.peso = peso;
		this.destino = destino;
		this.entregador = entregador;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public void exibirInformacoes(){
		System.out.println("Código: " + this.codigo);
		System.out.println("Peso: " + this.peso);
		System.out.println("Destino: " + this.destino);
		System.out.println("Entregador: " + this.entregador.getNome());
	}

	public FuncionarioEntrega getEntregador() {
		return entregador;
	}

	public void setEntregador(FuncionarioEntrega entregador) {
		this.entregador = entregador;
	}
	
	
	
}
