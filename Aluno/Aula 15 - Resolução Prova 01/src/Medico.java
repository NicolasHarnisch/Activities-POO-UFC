public class Medico extends Profissional{
	
	private String especialidade;
	private double salarioBase;
	
	public Medico(String nome, String cpf, String registro, String especialidade, double salarioBase) {
		super(nome, cpf, registro);
		this.especialidade = especialidade;
		this.salarioBase = salarioBase;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	@Override
	public String getTipoProfissional() {
		return "Medico";
	}
	
	@Override
	public void imprimeDados() {
		super.imprimeDados();
		System.out.println("Especialidade: " + this.especialidade);
		System.out.println("Salario Base: " + this.salarioBase);
	}
}
