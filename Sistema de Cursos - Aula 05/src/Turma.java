public class Turma {
	
	int codigoTurma;
	Disciplina disciplina;
	int capacidade;
	int qtdMatriculados;
	String horario;
	int ano;
	int semestre;
	
	Turma(int codigoTurma, Disciplina disciplina, int capacidade, String horario, int ano, int semestre) {
		this.codigoTurma = codigoTurma;
		this.disciplina = disciplina;
		this.capacidade = capacidade;
		this.horario = horario;
		this.ano = ano;
		this.semestre = semestre;
		this.qtdMatriculados = 0;
	}
	
	
	
}
