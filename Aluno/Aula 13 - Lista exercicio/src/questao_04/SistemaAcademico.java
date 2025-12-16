package questao_04;

import java.util.ArrayList;

public class SistemaAcademico {
    private ArrayList<Aluno> listaAlunos;
    private ArrayList<Professor> listaProfessores;
    private ArrayList<Disciplina> listaDisciplinas;

    public SistemaAcademico() {
        this.listaAlunos = new ArrayList<>();
        this.listaProfessores = new ArrayList<>();
        this.listaDisciplinas = new ArrayList<>();
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<Aluno> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

    public ArrayList<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(ArrayList<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    public ArrayList<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public void setListaDisciplinas(ArrayList<Disciplina> listaDisciplinas) {
        this.listaDisciplinas = listaDisciplinas;
    }

    // Metodos
    public void registrarProfessor(Professor professor) {
        this.listaProfessores.add(professor);
    }

    public void registrarAluno(Aluno aluno) {
        this.listaAlunos.add(aluno);
    }

    public void registrarDisciplina(Disciplina disciplina) {
        this.listaDisciplinas.add(disciplina);
    }

    public void associarProfessorDisciplina(Professor professor, Disciplina disciplina) {
        disciplina.setProfessorResponsavel(professor);
        System.out.println("Professor associado a Disciplina");
    }

    public void associarDisciplinaMatricula(Disciplina disciplina, Matricula matricula) {
        matricula.setDisciplina(disciplina);
    }

    public double calcularMediaAluno(Aluno aluno) {
        ArrayList<Matricula> lista = aluno.getListaMatricula();
        double somaNotas = 0;
        int totalDeMaterias = lista.size();

        for (int i = 0; i < totalDeMaterias; i++) {
            Matricula matriculaAtual = lista.get(i);

            somaNotas = somaNotas + matriculaAtual.getNota();
        }
        if (totalDeMaterias == 0) {
            return 0.0;
        }

        return somaNotas / totalDeMaterias;
    }

    public static void main(String[] args) {
        SistemaAcademico sistema = new SistemaAcademico();

        Professor prof1 = new Professor("Dr. Silva", "111.222.333-44", 5000.00, 10);
        sistema.registrarProfessor(prof1);

        Disciplina disc1 = new Disciplina("Programação Orientada a Objetos", 64, prof1);
        Disciplina disc2 = new Disciplina("Banco de Dados", 64, prof1);
        sistema.registrarDisciplina(disc1);
        sistema.registrarDisciplina(disc2);

        Aluno aluno1 = new Aluno("João", "555.666.777-88", 202301);
        sistema.registrarAluno(aluno1);

        Matricula mat1 = new Matricula(disc1, 8.5, 90);
        Matricula mat2 = new Matricula(disc2, 7.0, 85);

        aluno1.getListaMatricula().add(mat1);
        aluno1.getListaMatricula().add(mat2);

        System.out.println("Aluno: " + aluno1.getNome());
        System.out.println("Média: " + sistema.calcularMediaAluno(aluno1));

        System.out.println("Status Disciplina 1:");
        mat1.verificarAprovacao();

        System.out.println("Status Disciplina 2:");
        mat2.verificarAprovacao();
    }
}