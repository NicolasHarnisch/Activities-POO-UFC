import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	private static ArrayList<Encomenda> encomendas;
	private static ArrayList<FuncionarioEntrega> entregadores;
	private static Scanner s;
	
	public static void cadastrarEntregador() {
		String nome;
		int matricula;
		
		System.out.println("Digite o nome do entregador: ");
		nome = s.nextLine();
		System.out.println("Digite a matricula do entregador: ");
		matricula = s.nextInt();
		s.nextLine(); // Limpa \n
		
		entregadores.add(new FuncionarioEntrega(nome, matricula));
	}
	
	private static FuncionarioEntrega selecionarEntregador() {
		if(entregadores.isEmpty()) {
			System.out.println("Nenhum entregador cadastrado!");
			return null;
		}
		
		int opcao;
		System.out.println("Digite: ");
		for (int i = 0; i < entregadores.size(); i++) {
			System.out.println((i+1) + ": " + entregadores.get(i).getNome());

		}
		
		opcao = s.nextInt();
		s.nextLine(); // Limpa \n
		
		if(opcao < 1 || opcao > entregadores.size()) {
			System.out.println("[ERRO] Opção Inválida");
			return selecionarEntregador();
		}
		
		return entregadores.get(opcao - 1);
	}
	
	private static Encomenda selecionarEncomenda() {
		if(encomendas.isEmpty()) {
			System.out.println("Nenhuma encomenda cadastrada!");
			return null;
		}
		
		int opcao;
		System.out.println("Digite: ");
		for (int i = 0; i < encomendas.size(); i++) {
			System.out.println((i+1) + ":");
			encomendas.get(i).exibirInformacoes();
		}
		
		opcao = s.nextInt();
		s.nextLine(); // Limpa \n
		
		if(opcao < 1 || opcao > encomendas.size()) {
			System.out.println("[ERRO] Opção Inválida");
			return selecionarEncomenda();
		}
		
		return encomendas.get(opcao - 1);
	}
	
	public static void cadastrarEncomenda() {
		int codigo;
		String destino;
		double peso;
		FuncionarioEntrega entregador;
		
		System.out.println("Digite o codigo da encomenda: ");
		codigo = s.nextInt();
		s.nextLine(); // Limpa \n
		
		System.out.println("Digite o destino da encomenda: ");
		destino = s.nextLine();
		
		System.out.println("Digite o peso da encomenda: ");
		peso = s.nextDouble();
		s.nextLine(); // Limpa \n
		
		entregador = selecionarEntregador();
		if(entregador == null){
			return;
		}
		
		encomendas.add(new EncomendaExpressa(codigo, peso, destino, entregador));
	}
	
	public static void atualizarLocalizacao() {
		Encomenda encomenda = selecionarEncomenda();
		
		if(encomenda == null) {
			return;
		}
		
		System.out.println("Digite a nova localizacao: ");
		String local = s.nextLine();
		
		encomenda.exibirInformacoes();
		
		((EncomendaExpressa) encomenda).atualizarLocalizacao(local);
	}
	
	public static void exibirHistorico() {
		Encomenda encomenda = selecionarEncomenda();
		
		if(encomenda == null) {
			return;
		}
		
		
		System.out.println(((EncomendaExpressa) encomenda).obterHistorico());
	}
	
	public static void enviarMensagemEncomenda() {
		
		Encomenda encomenda = selecionarEncomenda();
		
		if(encomenda == null) {
			return;
		}
		
		System.out.println("Digite a mensagem a ser enviada: ");
		String mensagem = s.nextLine();
		
		((EncomendaExpressa) encomenda).enviarNotificacao(mensagem);
	}
	
	public static void enviarMensagemEntregador() {
		FuncionarioEntrega entregador = selecionarEntregador();
		
		if(entregador == null) {
			return;
		}
		
		System.out.println("Digite a mensagem a ser enviada: ");
		String mensagem = s.nextLine();
		
		entregador.enviarNotificacao(mensagem);
	}
	
	public static void main(String[] args) {
		encomendas = new ArrayList<Encomenda>();
		entregadores = new ArrayList<FuncionarioEntrega>();
		s = new Scanner(System.in);
		
		int opcao;
		
		do {
			System.out.println("Menu:\n1 - Cadastrar Entregador\n2 - Cadastrar Encomenda\n3 - Atualizar Localizacao de Encomenda\n4 - Exibir historico de encomenda\n5 - Enviar Mensagem Encomenda\n6 - Enviar mensagem entregador\n7 - sair");			
			opcao = s.nextInt();
			s.nextLine(); // Limpa \n
			switch (opcao) {
				case 1:
					cadastrarEntregador();
					break;
				case 2:
					cadastrarEncomenda();
					break;
				case 3:
					atualizarLocalizacao();
					break;
				case 4:
					exibirHistorico();
					break;
				case 5:
					enviarMensagemEncomenda();
					break;
				case 6:
					enviarMensagemEntregador();
					break;
				case 7:
					System.out.println("Você saiu!");
					break;
				default:
					System.out.println("Opção Inválida!");
			}
			
		}while(opcao != 7);
		
	}

}
