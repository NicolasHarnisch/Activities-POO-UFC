import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SistemaAtendimento {

    private ArrayList<Profissional> profissionais;
    private ArrayList<Atendimento> atendimentos;
    private Scanner entrada;

    public SistemaAtendimento() {
        profissionais = new ArrayList<>();
        atendimentos = new ArrayList<>();
        entrada = new Scanner(System.in);
    }

    // ==============================
    // 1. CADASTRAR PROFISSIONAL
    // ==============================
    public void cadastrarProfissional() {
        String nome, cpf, registro;
        int opcao;
        System.out.print("Digite o nome do profissional: ");
        nome = entrada.nextLine();
        System.out.print("Digite o cpf do profissional: ");
        cpf = entrada.nextLine();
        System.out.print("Digite o registro do profissional: ");
        registro = entrada.nextLine();
        
        System.out.println("Digite: 1 para médico e 2 para enfermeiro");
        opcao = entrada.nextInt();
        entrada.nextLine(); // Limpa \n
        
        if(opcao == 1) {
        	String especialidade;
        	double salarioBase;
        	
        	System.out.print("Digite a especialidade do medico: ");
            especialidade = entrada.nextLine();
            System.out.print("Digite o salario base: ");
            salarioBase = entrada.nextDouble();
            entrada.nextLine(); // Limpa \n
            profissionais.add(new Medico(nome, cpf, registro, especialidade, salarioBase));
        }else if(opcao == 2) {
        	int cargaHoraria;
        	String setor;
        	System.out.print("Digite a carga horaria do enfermeiro: ");
        	cargaHoraria = entrada.nextInt();
        	entrada.nextLine(); // Limpa \n
        	System.out.print("Digite o setor do enfermeiro: ");
        	setor = entrada.nextLine();
        	profissionais.add(new Enfermeiro(nome, cpf, registro, cargaHoraria, setor));
        }else {
        	System.out.println("Opção Inválida");
        	this.cadastrarProfissional();
        }
        
    }

    // =====================================================
    // 2. REGISTRAR ATENDIMENTO
    // =====================================================
    public void registrarAtendimento() {
        int codigo, dia, mes, ano;
        String nomePaciente, cpf;
        Date data;
        Profissional profissionalResponsavel;
        
        System.out.print("Digite o codigo do atendimento: ");
        codigo = entrada.nextInt();
        entrada.nextLine(); // Limpa \n
        System.out.print("Digite o nome do paciente: ");
        nomePaciente = entrada.nextLine();
        System.out.print("Digite o cpf do paciente: ");
        cpf = entrada.nextLine();
        System.out.print("Digite o dia do atendimento: ");
        dia = entrada.nextInt();
        entrada.nextLine(); // Limpa \n
        System.out.print("Digite o mes do atendimento: ");
        mes = entrada.nextInt();
        entrada.nextLine(); // Limpa \n
        System.out.print("Digite o ano do atendimento: ");
        ano = entrada.nextInt();
        entrada.nextLine(); // Limpa \n
        
        data = new Date(ano, mes, dia);
        
        int opcao;
        System.out.println("Digite: ");
        for (int i = 0; i < profissionais.size(); i++) {
			System.out.println((i+1) + " - " + profissionais.get(i).nome + "(" + profissionais.get(i).getTipoProfissional() + ")") ;
		}
        opcao = entrada.nextInt();
        entrada.nextLine(); // Limpa \n
        
        if(opcao <= 0 || opcao > profissionais.size()) {
        	System.out.println("Opção Inválida");
        	this.registrarAtendimento();
        	return;
        }
        
        profissionalResponsavel = profissionais.get(opcao - 1);
        
        System.out.println("Digite: 1 - para consulta, 2 - para Exame e 3 - para Procedimento");
        opcao = entrada.nextInt();
        entrada.nextLine(); // Limpa \n
        
        if(opcao == 1) {
        	int duracaoMinutos;
        	double valorBase;
        	System.out.print("Digite a duracao em minutos: ");
        	duracaoMinutos = entrada.nextInt();
        	entrada.nextLine(); // Limpa \n
        	System.out.print("Digite o valor base: ");
        	valorBase = entrada.nextDouble();
        	entrada.nextLine(); // Limpa \n
        	atendimentos.add(new Consulta(codigo, nomePaciente, cpf, data, profissionalResponsavel, duracaoMinutos, valorBase));
        }else if(opcao == 2) {
        	String tipoExame;
        	double taxa;
        	System.out.print("Digite o tipo do exame: ");
        	tipoExame = entrada.nextLine();
        	System.out.print("Digite a taxa do exame: ");
        	taxa = entrada.nextDouble();
        	entrada.nextLine(); // Limpa \n
        	atendimentos.add(new Exame(codigo, nomePaciente, cpf, data, profissionalResponsavel, tipoExame, taxa));
        }else if(opcao == 3) {
        	String material;
        	double custoOperacional;
        	System.out.print("Digite o material utilizado no procedimento: ");
        	material = entrada.nextLine();
        	System.out.print("Digite o custo operacional do procedimento: ");
        	custoOperacional = entrada.nextDouble();
        	entrada.nextLine(); // Limpa \n
        	atendimentos.add(new Procedimento(codigo, nomePaciente, cpf, data, profissionalResponsavel, material, custoOperacional));
        }else {
        	System.out.println("Opção Inválida");
        	this.registrarAtendimento();
        }
    }

    // =====================================================
    // 3. VALOR TOTAL ARRECADADO (POLIMORFISMO)
    // =====================================================
    public void calcularArrecadacao() {
        double total = 0;
        for (Atendimento atendimento : atendimentos) {
			total += atendimento.calcularValor();
		}
        System.out.println("Valor total arrecadado: R$ " + total);
    }

    // =====================================================
    // 4. LISTAR PROFISSIONAIS
    // =====================================================
    public void listarProfissionais() {
        for (Profissional profissional : profissionais) {
			profissional.imprimeDados();
		}
    }

    // =====================================================
    // 5. LISTAR ATENDIMENTOS POR PROFISSIONAL
    // =====================================================
    public void listarAtendimentosPorProfissional() {
    	
    	System.out.println("Digite: ");
        for (int i = 0; i < profissionais.size(); i++) {
			System.out.println((i+1) + " - " + profissionais.get(i).nome + "(" + profissionais.get(i).getTipoProfissional() + ")") ;
		}
        int opcao = entrada.nextInt();
        entrada.nextLine(); // Limpa \n
        
        if(opcao <= 0 || opcao > profissionais.size()) {
        	System.out.println("Opção Inválida");
        	this.listarAtendimentosPorProfissional();
        	return;
        }
        
        Profissional profissional = profissionais.get(opcao - 1);
        
        for (Atendimento atendimento : atendimentos) {
			if(atendimento.getProfissionalResponsavel() == profissional) {
				atendimento.imprimeResumo();
			}
		}
        
    }

    public void menu() {
        int opc = -1;

        while (opc != 0) {
            System.out.println("===== MENU =====");
            System.out.println("1 - Cadastrar profissional");
            System.out.println("2 - Registrar atendimento");
            System.out.println("3 - Calcular arrecadação");
            System.out.println("4 - Listar profissionais");
            System.out.println("5 - Listar atendimentos por profissional");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opc = entrada.nextInt();
            entrada.nextLine();

            switch (opc) {
                case 1: cadastrarProfissional(); break;
                case 2: registrarAtendimento(); break;
                case 3: calcularArrecadacao(); break;
                case 4: listarProfissionais(); break;
                case 5: listarAtendimentosPorProfissional(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!\n");
            }
        }
    }

    // =====================================================
    // MAIN
    // =====================================================
    public static void main(String[] args) {
        SistemaAtendimento sistema = new SistemaAtendimento();
        sistema.menu();
    }
}
