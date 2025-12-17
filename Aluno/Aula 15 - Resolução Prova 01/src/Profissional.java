public abstract class Profissional {
	String nome;
	String cpf;
	String registro;
	
	Profissional(String nome, String cpf, String registro) {
		this.nome = nome;
		this.cpf = cpf;
		this.registro = registro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
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
