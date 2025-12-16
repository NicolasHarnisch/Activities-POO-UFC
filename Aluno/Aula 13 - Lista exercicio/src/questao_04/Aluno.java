package questao_04;

import java.util.ArrayList;

public class Aluno extends Pessoa {
    private int matricula;
    private ArrayList<Matricula> listaMatricula;

    public Aluno(String nome, String cpf, int matricula) {
        super(nome, cpf);
        this.matricula = matricula;
        this.listaMatricula = new ArrayList<>();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public ArrayList<Matricula> getListaMatricula() {
        return listaMatricula;
    }

    public void setListaMatricula(ArrayList<Matricula> listaMatricula) {
        this.listaMatricula = listaMatricula;
    }


}
