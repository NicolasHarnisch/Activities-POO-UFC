import java.util.Date;

public abstract class Atendimento {
	
	private int codigo;
	private String nomePaciente;
	private String cpf;
	private Date data;
	private Profissional profissionalResponsavel;
	
	Atendimento(int codigo, String nomePaciente, String cpf, Date data, Profissional profissionalResponsavel) {
		this.codigo = codigo;
		this.nomePaciente = nomePaciente;
		this.cpf = cpf;
		this.data = data;
		this.profissionalResponsavel = profissionalResponsavel;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Profissional getProfissionalResponsavel() {
		return profissionalResponsavel;
	}

	public void setProfissionalResponsavel(Profissional profissionalResponsavel) {
		this.profissionalResponsavel = profissionalResponsavel;
	}
	
	public abstract double calcularValor();
	
	public void imprimeResumo() {
		System.out.println("Codigo: " + this.codigo);
		System.out.println("Nome Paciente: " + this.nomePaciente);
		System.out.println("CPF Paciente: " + this.cpf);
		System.out.println("Data: " + this.data);
		System.out.println("Nome Profissional: " + this.profissionalResponsavel.nome);
		System.out.println("Tipo Profissional: " + this.profissionalResponsavel.getTipoProfissional());		
	}
	
}
