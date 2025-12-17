import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SistemaAtendimento {

    private ArrayList<Profissional> profissionais;
    private ArrayList<Atendimento> atendimentos;

    public SistemaAtendimento() {
        profissionais = new ArrayList<>();
        atendimentos = new ArrayList<>();
    }

    public ArrayList<Profissional> getProfissionais() {
        return profissionais;
    }

    public void setProfissionais(ArrayList<Profissional> profissionais) {
        this.profissionais = profissionais;
    }

    public ArrayList<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(ArrayList<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    // ==============================
    // 1. CADASTRAR PROFISSIONAL
    // ==============================
    public void cadastrarProfissional() {
        Medico m = new Medico("Dr. João", "111.111", "CRM123", "Cardio", 2000.0);
        profissionais.add(m);
        Enfermeiro e = new Enfermeiro("Enf. Maria", "222.222", "COREN456", 40, "UTI");
        profissionais.add(e);
    }

    // =====================================================
    // 2. REGISTRAR ATENDIMENTO
    // =====================================================
    public void registrarAtendimento() {
        Atendimento a1 = new Consulta(1, "Paciente Ana", "000.000", "10/10/2006", medico, 30, 150.0);
        atendimentos.add(a1);

        Atendimento a2 = new Exame(2, "Paciente Beto", "111.111", "20/10/2007", medico, "Raio X", 80.0);
        atendimentos.add(a2);
    }

    // =====================================================
    // 3. VALOR TOTAL ARRECADADO (POLIMORFISMO)
    // =====================================================
    public void calcularArrecadacao() {
        double total = 0;
        for (Atendimento a : atendimentos) {
            total += a.calcularValor();
        }
        System.out.println("Total Arrecadado: R$ " + total);
    }

    // =====================================================
    // 4. LISTAR PROFISSIONAIS
    // =====================================================
    public void listarProfissionais() {
        System.out.println("--- Lista de Profissionais ---");
        for (Profissional p : profissionais) {
            System.out.println("Prof: " + p.getNome());
    }

    // =====================================================
    // 5. LISTAR ATENDIMENTOS POR PROFISSIONAL
    // =====================================================
    public void listarAtendimentosPorProfissional() {

    }

    public void menu() {
        this.cadastrarProfissional();
        this.registrarAtendimento();
        this.listarProfissionais();
        this.calcularArrecadacao();
        this.listarAtendimentosPorProfissional();
    }

    // =====================================================
    // MAIN
    // =====================================================
    public static void main(String[] args) {
        SistemaAtendimento sistema = new SistemaAtendimento();
        sistema.menu();
    }
}
