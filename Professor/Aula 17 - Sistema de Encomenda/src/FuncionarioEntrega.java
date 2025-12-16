public class FuncionarioEntrega implements Notificavel {
	
	private String nome;
	private int matricula;
	
	FuncionarioEntrega(String nome, int matricula) {
		this.nome = nome;
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	@Override
	public void enviarNotificacao(String mensagem) {
		System.out.println("Entregador: " + mensagem);
	}
	
}
