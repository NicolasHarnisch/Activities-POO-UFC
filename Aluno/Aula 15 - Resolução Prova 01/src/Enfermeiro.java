public class Enfermeiro extends Profissional {
	
	private int cargaHoraria;
	private String setor;
	
	Enfermeiro(String nome, String cpf, String registro, int cargaHoraria, String setor) {
		super(nome, cpf, registro);
		this.cargaHoraria = cargaHoraria;
		this.setor = setor;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}



	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}



	public String getSetor() {
		return setor;
	}



	public void setSetor(String setor) {
		this.setor = setor;
	}



	@Override
	public String getTipoProfissional() {
		return "Enfermeiro";
	}
	
	@Override
	public void imprimeDados() {
		super.imprimeDados();
		System.out.println("Carga Horaria: " + this.cargaHoraria + "h");
		System.out.println("Setor: " + this.setor);
	}
	
	
}
