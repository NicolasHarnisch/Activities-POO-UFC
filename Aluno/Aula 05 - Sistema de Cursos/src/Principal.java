public class Principal {
	
	static Aluno [] alunos;
	static Disciplina [] disciplinas;
	static Turma [] turmas;
	static Curso [] cursos;
	static Matricula [] matriculas;
	
	public static Matricula realizaMatricula(Aluno aluno, Turma turma) {
		
		boolean flag = false;
		for(int i = 0; i < aluno.curso.disciplinas.length; i++) {
			if(turma.disciplina.equals(aluno.curso.disciplinas[i])) {
				flag = true;
				break;
			}
		}		
		
		if(!flag) {
			System.out.println("[ERRO] A disciplina não pertence ao curso do aluno!");
			return null;
		}
		
		if(turma.capacidade == turma.qtdMatriculados) {
			System.out.println("[ERRO] A turma está lotada!");
			return null;
		}
		
		for(Disciplina disciplina : turma.disciplina.preRequisitos) {
			flag = false;
			for(Matricula matricula: matriculas) {
				if(matricula.aluno.equals(aluno) &&  matricula.turma.disciplina.equals(disciplina) && matricula.aprovado()) {
					flag = true;
					break;
				}
			}
			if(!flag) {
				System.out.println("[ERRO] O aluno não cursou a disciplina " + disciplina.nome);
				return null;
			}
		}
		
		System.out.println("A matricula foi concluida!");
		return new Matricula(aluno, turma);
	}

	public static void main(String[] args) {
		Disciplina fup = new Disciplina("Fundamentos de Programação", "RUS001", 64, null);
		Disciplina lab = new Disciplina("Laboratorio de Programação", "RUS002", 64, new Disciplina[] {fup});
		Disciplina poo = new Disciplina("Programação Orientada a Objetos", "RUS003", 64, new Disciplina[] {fup, lab});
		Disciplina intCC = new Disciplina("Introdução a Ciência da Computação", "RUS004", 32, null);
		Disciplina intES = new Disciplina("Introdução a Engenharia de Software", "RUS005", 32, null);
		
		disciplinas = new Disciplina[] {fup, lab, poo, intCC, intES};
		
		Curso cc = new Curso("Ciência da Computação", 1, new Disciplina[] {intCC, fup, lab, poo});
		Curso es = new Curso("Engenharia de Software", 2, new Disciplina[] {intES, fup, lab, poo});
		
		cursos = new Curso[] {cc, es};
		
		Aluno aluno1 = new Aluno(1, "Robertty", "12345678910", cc);
		Aluno aluno2 = new Aluno(2, "Mikael", "12345678910", es);
		Aluno aluno3 = new Aluno(3, "Francineide", "12345678910", cc);
		Aluno aluno4 = new Aluno(4, "Pedro", "12345678910", cc);
		Aluno aluno5 = new Aluno(5, "Gabriel", "12345678910", es);
		
		alunos = new Aluno[] {aluno1, aluno2, aluno3, aluno4, aluno5};
		
		Turma turma1 = new Turma(1, fup, 54, "Seg 08:00 - 10:00", 2023, 1);
		Turma turma2 = new Turma(2, fup, 1, "Qua 10:00 - 12:00", 2023, 1);
		Turma turma3 = new Turma(1, lab, 54, "Ter 08:00 - 10:00", 2023, 2);
		Turma turma4 = new Turma(1, poo, 54, "Seg 08:00 - 10:00", 2024, 1);
		Turma turma5 = new Turma(2, poo, 54, "Seg 08:00 - 10:00", 2024, 1);
		Turma turma6 = new Turma(1, intCC, 54, "Seg 08:00 - 10:00", 2024, 2);
		Turma turma7 = new Turma(1, intES, 54, "Seg 08:00 - 10:00", 2024, 2);
		
		turmas = new Turma[] {turma1, turma2, turma3, turma4, turma5, turma6, turma7};
		
		Matricula matricula1 = new Matricula(aluno1, turma6);
		matricula1.consolidarMatricula(10, 87);
		Matricula matricula2 = new Matricula(aluno1, turma1);
		matricula2.consolidarMatricula(7, 65);
		Matricula matricula3 = new Matricula(aluno2, turma7);
		matricula3.consolidarMatricula(8, 85);
		Matricula matricula4 = new Matricula(aluno3, turma2);
		matricula4.consolidarMatricula(10, 100);
		Matricula matricula5 = new Matricula(aluno3, turma3);
		matricula5.consolidarMatricula(6, 75);
		
		matriculas = new Matricula[] {matricula1, matricula2, matricula3, matricula4, matricula5};
		
		realizaMatricula(aluno1, turma7);
		realizaMatricula(aluno1, turma3);
		realizaMatricula(aluno3, turma3);
		realizaMatricula(aluno5, turma2);
		
		
	}

}
