public class Matricula {
	
	Aluno aluno;
	Turma turma;
	double media;
	double frequencia;
	boolean consolidado;
	
	Matricula(Aluno aluno, Turma turma) {
		this.aluno = aluno;
		this.turma = turma;
		this.media = 0;
		this.frequencia = 0;
		this.consolidado = false;
		this.turma.qtdMatriculados++;
	}
	
	void consolidarMatricula(double media, double frequencia) {
		if(!this.consolidado) {
			this.media = media;
			this.frequencia = frequencia;
			this.consolidado = true;
		}
	}
	
	boolean aprovado() {
		if(this.consolidado && this.media >= 7  && frequencia >= 75) {
			return true;
		}else {
			return false;
		}
	}
	
}
