import java.util.Date;

public class Procedimento extends Atendimento{
	
	String material;
	double custoOperacional;
	
	Procedimento(int codigo, String nomePaciente, String cpf, Date data, Profissional profissionalResponsavel, String material, double custoOperacional) {
		super(codigo, nomePaciente, cpf, data, profissionalResponsavel);
		this.material = material;
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
