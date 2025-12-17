import java.util.Date;

public class Procedimento extends Atendimento{
	private String material;
	private double custoOperacional;
	
	Procedimento(int codigo, String nomePaciente, String cpf, String data, Profissional profissionalResponsavel, String material, double custoOperacional) {
		super(codigo, nomePaciente, cpf, data, profissionalResponsavel);
		this.material = material;
		this.custoOperacional = custoOperacional;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getCustoOperacional() {
		return custoOperacional;
	}

	public void setCustoOperacional(double custoOperacional) {
		this.custoOperacional = custoOperacional;
	}

	@Override
	public double calcularValor() {
		return this.custoOperacional + 50;
	}
	
	@Override 
	public void imprimeResumo() {
		super.imprimeResumo();
		System.out.println("Material: " + this.material);
		System.out.println("Custo Operacional: R$ " + this.custoOperacional);
	}

}
