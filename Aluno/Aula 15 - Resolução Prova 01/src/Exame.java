public class Exame extends Atendimento {
	
	public String tipoExame;
	public double taxa;
	
	Exame(int codigo, String nomePaciente, String cpf, String data, Profissional profissionalResponsavel, String tipoExame, double taxa) {
		super(codigo, nomePaciente, cpf, data, profissionalResponsavel);
		this.tipoExame = tipoExame;
		this.taxa = taxa;
	}

	public String getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

	public double getTaxa() {
		return taxa;
	}

	public void setTaxa(double taxa) {
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
