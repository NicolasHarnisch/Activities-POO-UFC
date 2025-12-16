import java.util.Date;

public class Exame extends Atendimento {
	
	public String tipoExame;
	public double taxa;
	
	Exame(int codigo, String nomePaciente, String cpf, Date data, Profissional profissionalResponsavel, String tipoExame, double taxa) {
		super(codigo, nomePaciente, cpf, data, profissionalResponsavel);
		this.tipoExame = tipoExame;
		this.taxa = taxa;
	}
	
	@Override
	public double calcularValor() {
		return 3 * this.taxa - 10;
	}
	
	@Override 
	public void imprimeResumo() {
		super.imprimeResumo();
		System.out.println("Tipo Exame: " + this.tipoExame);
		System.out.println("Taxa: R$ " + this.taxa);
	}

}
