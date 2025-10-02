public class Aluno {
	
	int matricula;
	String nome;
	String cpf;
	Curso curso;
	
	Aluno(int matricula, String nome, String cpf, Curso curso) {
		this.matricula = matricula;
		this.nome = nome;
		this.cpf = cpf;
		this.curso = curso;
	}
	
	boolean equals(Aluno aluno) {
		if(this.matricula == aluno.matricula) {
			return true;
		}else {
			return false;
		}
	}
	
}
