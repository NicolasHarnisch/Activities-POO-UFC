public class Disciplina {
	
	String nome;
	String codigo;
	int cargaHoraria;
	Disciplina [] preRequisitos;
	
	Disciplina(String nome, String codigo, int cargaHoraria, Disciplina[] preRequisitos) {
		this.nome = nome;
		this.codigo = codigo;
		this.cargaHoraria = cargaHoraria;
		this.preRequisitos = preRequisitos;
	}
	
	boolean equals(Disciplina disciplina) {
		if(this.codigo.equals(disciplina.codigo)) {
			return true;
		}else {
			return false;
		}
	}
	
}
