import java.util.Date;

public class Consulta extends Atendimento {
	
	protected int duracaoMinutos;
	protected double valorBase;
	
	Consulta(int codigo, String nomePaciente, String cpf, Date data, Profissional profissionalResponsavel, int duracaoMinutos, double valorBase) {
		super(codigo, nomePaciente, cpf, data, profissionalResponsavel);
		this.duracaoMinutos = duracaoMinutos;
		this.valorBase = valorBase;
	}

	@Override
	public double calcularValor() {
		return this.valorBase + 2 * this.duracaoMinutos;
	}
	
	@Override 
	public void imprimeResumo() {
		super.imprimeResumo();
		System.out.println("Duracao Minutos: " + this.duracaoMinutos);
		System.out.println("Valor Base: R$ " + this.valorBase);
	}
}
