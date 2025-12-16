package questao_04;

public class Matricula {
    private Disciplina disciplina;
    private double nota;
    private int frequencia;

    public Matricula(Disciplina disciplina, double nota, int frequencia) {
        this.disciplina = disciplina;
        this.nota = nota;
        this.frequencia = frequencia;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public boolean verificarAprovacao() {
        if (this.nota >= 7 && this.frequencia >= 75) {
            System.out.println("Aluno Aprovado na Disciplina " + this.disciplina.getNome());
            return true;
        } else {
            System.out.println("Aluno Reprovado na disciplina " + this.disciplina.getNome());
            return false;
        }
    }
}
