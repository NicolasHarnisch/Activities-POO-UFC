import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SistemaPagamentos {
	
	
	private static ArrayList<Pagamento> pagamentos;
	private static Scanner s;
	
	private static PagamentoDinheiro receberPagamentoDinheiro() {
		float valor, valor_recebido;
		Date data_transacao = new Date();
		System.out.println("Digite o valor do pagamento: ");
		valor = s.nextFloat();
		System.out.println("Digite o dia do pagamento: ");
		data_transacao.setDate(s.nextInt());
		System.out.println("Digite o mes do pagamento: ");
		data_transacao.setMonth(s.nextInt());
		System.out.println("Digite o ano do pagamento: ");
		data_transacao.setYear(s.nextInt());
		System.out.println("Digite o valor recebido: ");
		valor_recebido = s.nextFloat();
		return new PagamentoDinheiro(valor, data_transacao, valor_recebido);
	}
	
	private static PagamentoCartao receberPagamentoCartao() {
		float valor;
		String numero_cartao, bandeira;
		int quantidade_parcelas;
		Date data_transacao = new Date();
		System.out.println("Digite o valor do pagamento: ");
		valor = s.nextFloat();
		System.out.println("Digite o dia do pagamento: ");
		data_transacao.setDate(s.nextInt());
		System.out.println("Digite o mes do pagamento: ");
		data_transacao.setMonth(s.nextInt());
		System.out.println("Digite o ano do pagamento: ");
		data_transacao.setYear(s.nextInt());
		System.out.println("Digite o numero do cartao: ");
		s.nextLine();
		numero_cartao = s.nextLine();
		System.out.println("Digite a bandeira do cartao: ");
		bandeira = s.nextLine();
		System.out.println("Digite a quantidade de parcelas: ");
		quantidade_parcelas = s.nextInt();
		return new PagamentoCartao(valor, data_transacao, numero_cartao, bandeira, quantidade_parcelas);
	}
	
	private static PagamentoPIX receberPagamentoPIX() {
		float valor;
		Date data_transacao = new Date();
		String chave_pix, banco_origem;
		System.out.println("Digite o valor do pagamento: ");
		valor = s.nextFloat();
		System.out.println("Digite o dia do pagamento: ");
		data_transacao.setDate(s.nextInt());
		System.out.println("Digite o mes do pagamento: ");
		data_transacao.setMonth(s.nextInt());
		System.out.println("Digite o ano do pagamento: ");
		data_transacao.setYear(s.nextInt());
		System.out.println("Digite a chave pix: ");
		s.nextLine();
		chave_pix = s.nextLine();
		System.out.println("Digite o banco origem: ");
		banco_origem = s.nextLine();
		return new PagamentoPIX(valor, data_transacao, chave_pix, banco_origem);
	}
	
	public static void main(String []args) {
		
		pagamentos = new ArrayList<Pagamento>();
		
		int opcao, opcao_pagamento, indice;
		
		s = new Scanner(System.in);
		
		do {
			System.out.println("Menu:\n1 - Cadastrar Pagamento \n2 - Processar Pagamento\n3 - Processar Todos os Pagamentos\n4 - Exibir Comprovante\n5 - Exibir Todos os Comprovante\n6 - Sair");
			opcao = s.nextInt();
			switch (opcao) {
			case 1:
				System.out.println("Escolhar a forma:\n1 - Pagamento em Dinheiro\n2 - Pagamento em Cartao\n3 - Pagamento PIX");
				opcao_pagamento = s.nextInt();
				switch (opcao_pagamento) {
				case 1:
					pagamentos.add(receberPagamentoDinheiro());
					break;
				case 2:
					pagamentos.add(receberPagamentoCartao());
					break;
				case 3:
					pagamentos.add(receberPagamentoPIX());
					break;
				default:
					System.out.println("[Erro] Opção de Pagamento Inválida!");
					break;
				}
				break;
			case 2:
				System.out.println("Digite o indice do pagamento: ");
				indice = s.nextInt();
				if(pagamentos.get(indice).processarPagamento()) {
					System.out.println("Processamento realizado com sucesso!");
				}else {
					System.out.println("Pagamento já foi processado!");
				}
				break;
			case 3:
				for (Pagamento pagamento : pagamentos) {
					if(pagamento.processarPagamento()) {
						System.out.println("Processamento realizado com sucesso!");
					}else {
						System.out.println("Pagamento já foi processado!");
					}
				}
				break;
			case 4:
				System.out.println("Digite o indice do pagamento: ");
				indice = s.nextInt();
				pagamentos.get(indice).exibirComprovante();
				break;
			case 5:
				for (Pagamento pagamento : pagamentos) {
					pagamento.exibirComprovante();
				}
				break;
			case 6:
				System.out.println("Você saiu!");
				break;
			default:
				System.out.println("[Erro] Opção Inválida!");
			}
		} while (opcao != 6);
		
	}
	
	
}
