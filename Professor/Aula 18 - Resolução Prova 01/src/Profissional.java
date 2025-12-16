public abstract class Profissional {
	
	String nome;
	String cpf;
	String registro;
	
	Profissional(String nome, String cpf, String registro) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
	}
	
	public abstract String getTipoProfissional();
	
	public void imprimeDados() {
		System.out.println("Nome: " + this.nome);
		System.out.println("CPF: " + this.cpf);
		System.out.println("Registro: " + this.registro);
		System.out.println("Tipo: " + this.getTipoProfissional());
	}
	
}
